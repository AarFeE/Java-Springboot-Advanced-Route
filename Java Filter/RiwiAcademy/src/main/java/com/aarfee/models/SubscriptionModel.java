package com.aarfee.models;

import com.aarfee.entities.CourseEntity;
import com.aarfee.entities.SubscriptionEntity;
import com.aarfee.persistence.connection.MySQLConfig;
import com.aarfee.persistence.imodels.ISubscriptionModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionModel implements ISubscriptionModel {
    @Override
    public void create(SubscriptionEntity req) {
        Connection connection = MySQLConfig.openConnection();
        String query = "INSERT INTO Subscription(student_id, course_id) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, req.getStudentId());
            preparedStatement.setInt(2, req.getCourseId());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Subscription Correctly Created!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public SubscriptionEntity readById(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        SubscriptionEntity foundSubscription = null;

        String query = "SELECT * FROM Subscription WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                foundSubscription = new SubscriptionEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return foundSubscription;
    }

    @Override
    public SubscriptionEntity checkSubscription(int studentId, int courseId) {
        Connection connection = MySQLConfig.openConnection();
        SubscriptionEntity foundSubscription = null;

        String query = "SELECT * FROM Subscription WHERE student_id = ? AND course_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                foundSubscription = new SubscriptionEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return foundSubscription;
    }

    @Override
    public String readStudentCourseById(int id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "select Subscription.id, Course.name, Student.email from Subscription " +
                "join Course on Subscription.course_id = Course.id join Student on Subscription.student_id = Student.id  where Subscription.id = ?";
        String subscription = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                subscription = "id: " + resultSet.getString("id") + ", Course Name: " +
                        resultSet.getString("name") + ", Student Email: " + resultSet.getString("email");
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }

        return subscription;
    }

    @Override
    public String readStudentsCourses() {
        Connection connection = MySQLConfig.openConnection();
        String query = "select Subscription.id, Course.name, Student.email from Subscription " +
                "join Course on Subscription.course_id = Course.id join Student on Subscription.student_id = Student.id";
        String subscription = "";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                subscription += "id: " + resultSet.getString("id") + ", Course Name: " +
                        resultSet.getString("name") + ", Student Email: " + resultSet.getString("email") + "\n";
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }

        return subscription;
    }

    @Override
    public List<SubscriptionEntity> readAll() {
        List<SubscriptionEntity> subscriptions = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Subscription";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                SubscriptionEntity addSubscription = new SubscriptionEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("student_id"),
                        resultSet.getInt("course_id"));

                subscriptions.add(addSubscription);
            }
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }

        return subscriptions;
    }

    @Override
    public void update(SubscriptionEntity req, Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Subscription SET student_id = ?, course_id = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, req.getStudentId());
            preparedStatement.setInt(2, req.getCourseId());
            preparedStatement.setInt(3, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Subscription Correctly Updated!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }

    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "DELETE FROM Subscription WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Subscription Correctly Deleted!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }
}
