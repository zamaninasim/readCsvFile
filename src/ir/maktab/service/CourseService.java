package ir.maktab.service;

import ir.maktab.dao.CourseDao;
import ir.maktab.model.Course;

import java.sql.SQLException;

public class CourseService {
    CourseDao courseDao = new CourseDao();

    public CourseService() throws SQLException, ClassNotFoundException {
    }
    public void saveToDao(Course course) throws SQLException {
        courseDao.save(course);
    }
    public int getCourseId(Course course) throws SQLException {
        String name = course.getCourseName();
        int id = courseDao.findCourseIdByName(name);
        return id;
    }
}
