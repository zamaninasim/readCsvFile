package ir.maktab.dao;

import ir.maktab.model.StudentCourseRating;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentCourseRatingDao extends Dao {
    public StudentCourseRatingDao() throws ClassNotFoundException, SQLException {
    }

    public void save(StudentCourseRating studentCourseRating) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "INSERT INTO studentCourseRatings(rating,comment,studentId,courseId)" + "VALUES (?,?,?,?)";
            PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
            statement.setFloat(1, studentCourseRating.getRating());
            statement.setString(2,studentCourseRating.getComment());
            statement.setInt(3,studentCourseRating.getStudentId());
            statement.setInt(4,studentCourseRating.getCourseId());
            int resultSet = statement.executeUpdate();
        }
    }
}
