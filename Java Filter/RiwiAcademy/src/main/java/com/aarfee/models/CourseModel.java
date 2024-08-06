package com.aarfee.models;

import com.aarfee.entities.CourseEntity;
import com.aarfee.entities.StudentEntity;
import com.aarfee.persistence.connection.MySQLConfig;
import com.aarfee.persistence.imodels.ICourseModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseModel implements ICourseModel {
    @Override
    public void create(CourseEntity req) {
        Connection connection = MySQLConfig.openConnection();
        String query = "INSERT INTO Course(name, description) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getDescription());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Course Correctly Created!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public CourseEntity readById(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        CourseEntity foundCourse = null;

        String query = "SELECT * FROM Course WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                foundCourse = new CourseEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return foundCourse;
    }

    @Override
    public List<CourseEntity> readAll() {
        List<CourseEntity> courses = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Course";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CourseEntity addCourse = new CourseEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));

                courses.add(addCourse);
            }
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }

        return courses;
    }

    @Override
    public void update(CourseEntity req, Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Course SET name = ?, description = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getDescription());
            preparedStatement.setInt(3, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Course Correctly Updated!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "DELETE FROM Course WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Course Correctly Deleted!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }
}
