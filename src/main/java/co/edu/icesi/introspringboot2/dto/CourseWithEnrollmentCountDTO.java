package co.edu.icesi.introspringboot2.dto;

public class CourseWithEnrollmentCountDTO {
    private String courseName;
    private String professorName;
    private long enrollmentCount;

    public CourseWithEnrollmentCountDTO(String courseName, String professorName, long enrollmentCount) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.enrollmentCount = enrollmentCount;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public long getEnrollmentCount() {
        return enrollmentCount;
    }

    public void setEnrollmentCount(long enrollmentCount) {
        this.enrollmentCount = enrollmentCount;
    }
}