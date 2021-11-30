package ir.maktab.model;

import java.sql.Timestamp;

public class Course {
    private String courseName;
    private Timestamp timestamp;
    private int studentId;

    public Course(String courseName, Timestamp timestamp, int studentId) {
        this.courseName = courseName;
        this.timestamp = timestamp;
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
