package com.aarfee.models;

import com.aarfee.entities.GradeEntity;
import com.aarfee.entities.SubscriptionEntity;
import com.aarfee.persistence.connection.MySQLConfig;
import com.aarfee.persistence.imodels.IGradeModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeModel implements IGradeModel {

    @Override
    public void create(GradeEntity req) {
        Connection connection = MySQLConfig.openConnection();
        String query = "INSERT INTO Grade(subscription_id, value) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, req.getSubscriptionId());
            preparedStatement.setDouble(2, req.getValue());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Grade Correctly Created!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public GradeEntity readById(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        GradeEntity foundGrade = null;

        String query = "SELECT * FROM Grade WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                foundGrade = new GradeEntity(
                        resultSet.getInt("id"),
                        resultSet.getDouble("value"),
                        resultSet.getInt("subscription_id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return foundGrade;
    }

    @Override
    public List<GradeEntity> readAll() {
        List<GradeEntity> grades = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Grade";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GradeEntity addGrade = new GradeEntity(
                        resultSet.getInt("id"),
                        resultSet.getDouble("value"),
                        resultSet.getInt("subscription_id"));

                grades.add(addGrade);
            }
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }

        return grades;
    }

    @Override
    public void update(GradeEntity req, Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Grade SET subscription_id = ?, value = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, req.getSubscriptionId());
            preparedStatement.setDouble(2, req.getValue());
            preparedStatement.setInt(3, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Grade Correctly Updated!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "DELETE FROM Grade WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Grade Correctly Deleted!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }
}
