package ir.maktab.dao;


import ir.maktab.model.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDao extends Dao {

    public CourseDao() throws ClassNotFoundException, SQLException {
    }

    public void save(Course course) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "INSERT INTO courses(name,timestamp,studentId)" + "VALUES (?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
            statement.setString(1, course.getCourseName());
            statement.setTimestamp(2,course.getTimestamp());
            statement.setInt(3,course.getStudentId());
            int resultSet = statement.executeUpdate();
        }
    }

    public int findCourseIdByName(String name) throws SQLException {
        String sqlQuery = "SELECT id FROM courses  WHERE name = ?";
        PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int courseId = resultSet.getInt("id");
            return courseId;
        }
        return 0;
    }

}
