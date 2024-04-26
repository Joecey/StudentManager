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
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Runner {
    public static boolean testing = false;
    public static void main(String[] args) {
        /* create a new instance of a student manager. In this case, we could potentially have multiple
        * StudentMangers should we choose to specify them*/
        StudentManager smNew = new StudentManager();

        // this is just a sample student with Data
        Student sTesting = new Student("123", "Joe", "Doe", LocalDate.now(), new Address("test address"),
                Course.WEB_DEV);

        // Run the test function
        if (testing){
            System.out.println("Running Student Manger 2024 - Test Data");
            testing(smNew, sTesting);
        } else{
            // Otherwise, run our menu
            System.out.println("Welcome to the Student Manager 2024 \n");

            // let's generate X random students
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String[] fnames = {"John", "Mary", "Jane", "Hagrid"};
            String[] lnames = {"O'Brien", "Sim Lam Bao", "Connors", "Bruh"};
            Course[] courses = Course.values();
            int maxDay = 28;
            int maxMonth = 12;
            int minYear = 1990;
            int maxYear = 2003;
            int maxRandStudents = 4;

            for (int i = 0; i < maxRandStudents; i++) {

                int randomDay = rand.nextInt(1, maxDay);
                int randomMonth = rand.nextInt(1, maxMonth);

                String rsDob = ((randomDay>=10) ? randomDay : "0" + randomDay )+ "/" +
                        ((randomMonth>=10) ? randomMonth : "0" + randomMonth ) + "/" +
                        rand.nextInt(minYear, maxYear);

                Student rs = new Student(
                        "G00"+i,
                        fnames[rand.nextInt(0, fnames.length)],
                        lnames[rand.nextInt(0, fnames.length)],
                        LocalDate.parse(rsDob, formatter),
                        new Address("Galway"),
                        courses[rand.nextInt(0, courses.length)]);
                smNew.add(rs);
                System.out.println("Added student: " + rs);
            }


            // now we open our custom menu
            Menu newMenu = new Menu(smNew);
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
