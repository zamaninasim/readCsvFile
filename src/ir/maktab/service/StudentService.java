package ir.maktab.service;

import ir.maktab.dao.StudentDao;
import ir.maktab.model.Student;

import java.sql.SQLException;

public class StudentService {
    StudentDao studentDao = new StudentDao();

    public StudentService() throws SQLException, ClassNotFoundException {
    }

    public void saveToDao(Student student) throws SQLException {
        studentDao.save(student);
    }
    public int getStudentId(Student student) throws SQLException {
        String name = student.getName();
        int id = studentDao.findStudentIdByName(name);
        return id;
    }

}
