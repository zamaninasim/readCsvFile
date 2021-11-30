package ir.maktab.dao;

import ir.maktab.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao extends Dao {
    public StudentDao() throws ClassNotFoundException, SQLException {
    }

    public void save(Student student) throws SQLException {
        if (getConnection() != null) {
            String sqlQuery = "INSERT INTO students(name)" + "VALUES (?)";
            PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
            statement.setString(1, student.getName());
            int resultSet = statement.executeUpdate();
        }
    }

    public int findStudentIdByName(String name) throws SQLException {
        String sqlQuery = "SELECT id FROM students  WHERE name = ?";
        PreparedStatement statement = getConnection().prepareStatement(sqlQuery);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int studentId = resultSet.getInt("id");
            return studentId;
        }
        return 0;
    }
}
