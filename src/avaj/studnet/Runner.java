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
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Student Manager 2024");
        StudentManager sm = new StudentManager();
        Student s = new Student("123", "Joe", "Doe", LocalDate.now(), new Address("test address"),
                Course.SOFT_DEV);

        // how will this work, calling methods from manager
        sm.add(s);
        System.out.println(Arrays.toString(sm.getStudentsByFirst("Joe")));
        System.out.println(sm.getStudentByID("123"));
        if (sm.delete(s.firstName())){
            // replace this check with a status
            System.out.println(s.firstName() + " successfully deleted!");
        };

    }
}
