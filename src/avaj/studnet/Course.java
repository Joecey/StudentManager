package avaj.studnet;

// CREATE NEW CONSTANTS FOR EACH OF THE COURSES
public enum Course {
    SOFT_DEV("Software Development", "Computing"),
    DATA_ANALY("Data Analyis", "Computing"),
    WEB_DEV("Web Application Development", "Computing"),
    CHEM("Chemistry", "Science"),
    PHYS("Physics", "Science"),
    MEDI("Medicine", "Medicine"),
    ACC("Accounting", "Comerce");

    private final String cname;
    private final String cfaculty;

    Course(String name, String faculty) {
        this.cname = name;
        this.cfaculty = faculty;
    }

    public String getCourseName() {
        return cname;
    }

    public String getCourseFaculty() {
        return cfaculty;
    }
}
