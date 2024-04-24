package avaj.studnet;
/*
 * GOALS:
 * 1) CLI menu that allows different operations
 * 2) Add a student to a temp database (no SQL, so it's only based on session).
 * Each student has an ID, Name, DoB and course
 * 3) Delete a student (specify name)
 * 4) Search for students by ID
 * 5) Output total students
 * 6) Exit
 * */

import java.time.LocalDate;

public class Runner {
    public static boolean testing = false;
    public static void main(String[] args) {
        /* create a new instance of a student manager. In this case, we could potentially have multiple
        * StudentMangers should we choose to specify them*/
        StudentManager smTesting = new StudentManager();

        // this is just a sample student with Data
        Student sTesting = new Student("123", "Joe", "Doe", LocalDate.now(), new Address("test address"),
                Course.WEB_DEV);

        // Run the test function
        if (testing){
            System.out.println("Running Student Manger 2024 - Test Data");
            testing(smTesting, sTesting);
        } else{
            // Otherwise, run our menu
            System.out.println("Welcome to the Student Manager 2024 \n");
            Menu newMenu = new Menu();
            newMenu.start();
        }


    }
    public static void testing(StudentManager smTest, Student studentTest){
        // testing, calling methods from manager
        smTest.add(studentTest);
        if (smTest.delete(studentTest.sid())){
            // replace this check with a status
            System.out.println(studentTest.firstName() + " successfully deleted!");
        }
    }
}
