package avaj.studnet;
// get input from user
// offload results

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.*;

public class Menu {
    // we will use this menu to get user input and that's it!
    private final Scanner s;
    private boolean running = true;
    private final StudentManager sm = new StudentManager();

    public Menu() {
        s = new Scanner(in);
    }

    public void start() {
        do {
            showOptions();
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> add();
                case 2 -> delete();
                case 3 -> findById();
                case 4 -> findStudentsByFirstName();
                case 5 -> getTotal();
                case 6 -> {
                    running = false;
                    out.println("See you later bozo!");
                }
                default -> out.println("Not an option. Please try again");

            }
        } while (running);

    }

    private void add() {
        out.println("Provide student details \n");
        // we need String sid, String firstName, String surname, LocalDate dob, Address address, Course course

        out.print("Enter Student ID: ");
        String sid = s.next();
        out.println();
        out.print("Enter Student First name: ");
        String firstName = s.next();
        out.println();
        out.print("Enter Student Last Name: ");
        String lastName = s.next();
        out.println();
        out.println("Assigning date of registration...");
        LocalDate dateOfReg = LocalDate.now();
        out.print("Enter Student Address: ");
        Address address = new Address("Galway"); // hard coded
        out.println();
        out.print("Enter Student Course: ");
        Course course = Course.SOFT_DEV; // hard coded
        out.println();

        Student tempStudent = new Student(sid, firstName, lastName, dateOfReg, address, course);
        sm.add(tempStudent);
        out.print("Student added! \n");
    }

    private void delete() {
        out.println("Deleting Student...Please provide studentId (sid) to delete");
        String sidToDelete = s.next();
        String result = sm.delete(sidToDelete) ? "Successfully Deleted - " + sidToDelete : "Student doesn't exist";
        out.println(result + "\n");
    }

    private void findById() {
        out.println("Find student by ID...Provide studentId to find");
        String sidToFind = s.next();
        Student foundStudent = sm.getStudentByID(sidToFind);
        if (foundStudent == null) {
            out.println("Student does not exist \n");
        } else {
            out.println(foundStudent);
        }
    }

    private void findStudentsByFirstName() {
        out.println("Find students by first name... Provide first name");
        String firstNameToFind = s.next();
        Student[] returnedStudents = sm.getStudentsByFirst(firstNameToFind);

        for (Student student : returnedStudents) {
            out.println(student);
        }

    }

    private void getTotal() {
        out.println("The total number of students in this database is " + sm.size());

    }

    private void showOptions() {
        out.println("^^^^ ^^^^ ^^^^ ^^^^ ^^^^ ^^^^");
        out.println("^^^^ Student Manager Menu ^^^^");
        out.println("^^^^ ^^^^ ^^^^ ^^^^ ^^^^ ^^^^");
        out.println("1) Add a student");
        out.println("2) Delete a student");
        out.println("3) Find student by ID");
        out.println("4) Find students by First name");
        out.println("5) Get total students");
        out.println("6) Quit");
        out.println("Select an option [1-6]");
    }

}
