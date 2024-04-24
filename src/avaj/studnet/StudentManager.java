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
    // create our Student database. We first need to set the initial capacity of our student database
    private static final int INITIAL_CAPACITY = 10;
    // then create Student array
    private Student[] students;

    public StudentManager() {
        students = new Student[INITIAL_CAPACITY];
    }

    //**** some methods that the manager will use ****
    // add a Student to our array of Students by slotting it into the next available null space
    public void add(Student s) {

        // notice in the records, we use <param>() to get the parameter from our Student object?
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                // if null, add a new student to the array (if there is room
                students[i] = s;
                System.out.println(Arrays.toString(students));
                return;

            }
        }
        /* If we are here, that means that there is no more empty space*/
        int index = getExpandedIndex();
        students[index] = s;

    }

    // run only if we run out of space in the current students array
    private int getExpandedIndex() {
        // if no room, double the initial size of students array and copy existing data
        // Step 1) Create a new array with double the existing students array length
        Student[] temp = new Student[students.length * 2];

        // Step 2) copy all the data from students into the temp array in order
        // there is also a method called arrayCopy, but we won't worry about that for now
        for (int i = 0; i < students.length; i++) {
            temp[i] = students[i];
        }

        // Step 3) set our new current index to the length of the original array (i.e. the next step)
        int index = students.length;
        // then set the new expanded array as temp

        // Step 4) Set temp to be our new students array
        students = temp;
        return index;
    }

    // Delete all students from array given the sid
    // notice that getStudentsByFirst() uses the same inputs, could we possibly combine these two functions together?
    public boolean delete(String sid) {
        for (int i = 0; i < students.length; i++) {
            // if current position is not null and the sid is equal to sid
            if (students[i] != null && students[i].sid().equals(sid)) {
                students[i] = null;

                // this ensures we only delete the first instance of the student name
                return true;
            }
        }
        return false;
    }

    // search student by sid
    public Student getStudentByID(String sid) {
        for (Student student : students) {
            // if current position is not null and the sid is equal to sid
            if (student != null && student.sid().equals(sid)) {
                return student;
            }
        }
        return null;
    }

    // return an array of students based on a matching Firstname
    public Student[] getStudentsByFirst(String firstname) {
        // we will be returning an array of students
        // first count,
        int matchCount = 0;
        for (Student student : students) {
            if (student != null && student.firstName().equals(firstname)) matchCount++;
        }
        // then create array
        Student[] matchingStudents = new Student[matchCount];
        int index = 0;

        // then append all names to array and return
        // we can make this a bit more efficient. But how?
        for (Student student : students) {
            if (student != null && student.firstName().equals(firstname)) {
                matchingStudents[index] = student;
                index++;
            }
        }
        return matchingStudents;
    }

    // return the size of our student database
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