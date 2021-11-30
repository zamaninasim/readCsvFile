package ir.maktab;

import ir.maktab.model.Course;
import ir.maktab.model.Student;
import ir.maktab.model.StudentCourseRating;
import ir.maktab.service.CourseService;
import ir.maktab.service.StudentCourseRatingsService;
import ir.maktab.service.StudentService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String csvFilePath = "D:\\barnamenevisi\\bootcamp\\homeworks\\projects\\hw13\\io-student\\resources\\student.csv";
        try (BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));) {
            StudentService studentService = new StudentService();
            CourseService courseService = new CourseService();
            StudentCourseRatingsService studentCourseRatingsService = new StudentCourseRatingsService();
            String lineText = null;
            lineReader.readLine(); //skip first line
            while ((lineText = lineReader.readLine())!=null) {
                String[] data = lineText.split(",");
                String courseName = data[0];
                String studentName = data[1];
                String timestamp = data[2];
                Timestamp sqlTimestamp = Timestamp.valueOf(timestamp);
                String rating = data[3];
                Float fRating = Float.parseFloat(rating);
                String comment = data[4];

                Student student = new Student(studentName);
                studentService.saveToDao(student);
                int studentId = studentService.getStudentId(student);
                Course course = new Course(courseName,sqlTimestamp,studentId);
                courseService.saveToDao(course);
                int courseId = courseService.getCourseId(course);
                StudentCourseRating studentCourseRating = new StudentCourseRating(fRating,comment,studentId,courseId);
                studentCourseRatingsService.saveToDao(studentCourseRating);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
    }
}