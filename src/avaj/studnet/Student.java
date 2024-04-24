package avaj.studnet;

import java.time.LocalDate;

// here, we are creating the Student using a RECORD
// RECORD is read-only - usually okay for most purposes.
// serves the same purpose as a student class with a bunch of get functions
public record Student(String sid, String firstName, String surname, LocalDate dob, Address address, Course course) {
}
