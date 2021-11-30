package ir.maktab.service;

import ir.maktab.dao.StudentCourseRatingDao;
import ir.maktab.model.StudentCourseRating;

import java.sql.SQLException;

public class StudentCourseRatingsService {
    StudentCourseRatingDao studentCourseRatingDao = new StudentCourseRatingDao();

    public StudentCourseRatingsService() throws SQLException, ClassNotFoundException {
    }

    public void saveToDao(StudentCourseRating studentCourseRating) throws SQLException {
        studentCourseRatingDao.save(studentCourseRating);
    }

}
