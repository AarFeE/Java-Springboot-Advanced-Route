package com.aarfee.models;

import com.aarfee.entities.StudentEntity;
import com.aarfee.persistence.connection.MySQLConfig;
import com.aarfee.persistence.imodels.IStudentModel;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IStudentModel {

    @Override
    public void create(StudentEntity req) {
        Connection connection = MySQLConfig.openConnection();
        String query = "INSERT INTO Student(name, email, state) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getEmail());
            preparedStatement.setInt(3, req.getState() ? 1 : 0);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Student Correctly Created!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public StudentEntity readById(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        StudentEntity foundStudent = null;

        String query = "SELECT * FROM Student WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                foundStudent = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("state") == 1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return foundStudent;
    }

    @Override
    public StudentEntity readByEmail(String email) {
        Connection connection = MySQLConfig.openConnection();
        StudentEntity foundStudent = null;

        String query = "SELECT * FROM Student WHERE email = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                foundStudent = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("state") == 1);
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return foundStudent;
    }

    @Override
    public List<StudentEntity> readAll() {
        List<StudentEntity> students = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Student";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentEntity addStudent = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("state") == 1);

                students.add(addStudent);
            }

            return students;
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public List<StudentEntity> readAllActive() {
        List<StudentEntity> students = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Student WHERE state = 1";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StudentEntity addStudent = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("state") == 1);

                students.add(addStudent);
            }

            return students;
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void update(StudentEntity req, Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Student SET name = ?, email = ?, state = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getEmail());
            preparedStatement.setInt(3, req.getState() ? 1 : 0);
            preparedStatement.setInt(4, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Student Correctly Updated!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "DELETE FROM Student WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Student Correctly Deleted!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }
}
