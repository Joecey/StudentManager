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

import java.util.Arrays;

public class StudentManager {
    // create our Student database
    private static final int INITIAL_CAPACITY = 10;
    private Student[] students = null;

    public StudentManager() {
        students = new Student[INITIAL_CAPACITY];
    }

    //**** some methods that the manager will use ****
    public void add(Student s) {
        System.out.println("student " + s.firstName() + " added");
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                // if null, add a new student to the array (if there is room
                students[i] = s;
                System.out.println(Arrays.toString(students));
                return;

            }
        }
        // handle if database is full
        int index = getExpandedIndex();
        students[index] = s;

    }

    // run only if we run out of space in the current students array
    private int getExpandedIndex() {
        // if no room, double the inital size of students array and copy existing data
        Student[] temp = new Student[students.length * 2];

        // there is also a method called arrayCopy, but we won't worry about that for now
        for (int i = 0; i < students.length; i++) {
            temp[i] = students[i];
        }
        //then set our new current index to the length of the original array
        int index = students.length;
        // then set the new expanded array as temp
        students = temp;
        return index;
    }

    public boolean delete(String firstName) {
        for (int i = 0; i < students.length; i++) {
            // if current position is not null and the sid is equal to sid
            if (students[i] != null && students[i].firstName().equals(firstName)) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }

    public Student getStudentByID(String sid) {
        for (Student student : students) {
            // if current position is not null and the sid is equal to sid
            if (student != null && student.sid().equals(sid)) {
                return student;
            }
        }
        return null;
    }

    public Student[] getStudentsByFirst(String firstname) {
        // we will be returning an array of students
        // first count, then create array
        int matchCount = 0;
        for (Student student : students) {
            if (student != null && student.firstName().equals(firstname)) matchCount++;
        }
        Student[] matchingStudents = new Student[matchCount];
        int index = 0;

        // we can make this a bit more efficient
        for (Student student : students) {
            if (student != null && student.firstName().equals(firstname)) {
                matchingStudents[index] = student;
                index++;
            }
        }
        // then append all names to array
        return matchingStudents;
    }

    public int size() {
        int total = 0;
        for (Student student : students) {
            if (student != null) total++;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Testing...");
    }


}