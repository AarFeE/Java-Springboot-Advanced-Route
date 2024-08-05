package com.aarfee.models;

import com.aarfee.entities.EnterpriseEntity;
import com.aarfee.entities.VacancyEntity;
import com.aarfee.persistance.configDB.MySQLConfig;
import com.aarfee.persistance.imodel.IVacancyModel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacancyModel implements IVacancyModel {

    @Override
    public void create(VacancyEntity req) {
        Connection connection = MySQLConfig.openConnection();
        String query = "INSERT INTO Vacancy(technology,description, enterprise_id, state) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getTechnology());
            preparedStatement.setString(2, req.getDescription());
            preparedStatement.setInt(3, req.getEnterpriseId());
            preparedStatement.setInt(4, req.getState() ? 1 : 0);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Vacancy Correctly Created!");
        } catch(SQLException e){
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public VacancyEntity readById(Integer id) {
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Vacancy WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                return new VacancyEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("technology"),
                        resultSet.getString("description"),
                        resultSet.getInt("enterprise_id"),
                        resultSet.getBoolean("state"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return null;
    }

    @Override
    public List<VacancyEntity> readAll() {
        List<VacancyEntity> vacancies = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Vacancy";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                VacancyEntity addVacancy = new VacancyEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("technology"),
                        resultSet.getString("description"),
                        resultSet.getInt("enterprise_id"),
                        resultSet.getBoolean("state"));

                vacancies.add(addVacancy);
            }

            return vacancies;
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void update(VacancyEntity req, Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Vacancy SET technology = ?, description = ?, enterprise_id = ?, state = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getDescription());
            preparedStatement.setString(2, req.getDescription());
            preparedStatement.setInt(3, req.getEnterpriseId());
            preparedStatement.setInt(4, req.getState() ? 1 : 0);
            preparedStatement.setInt(5, id);

            preparedStatement.execute();

            System.out.println("Vacancy Correctly Updated!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "DELETE FROM Vacancy WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            System.out.println("Vacancy Correctly Deleted!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void changeState(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Vacancy SET state = state XOR 1 where id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Vacancy State Correctly Changed!");
        } catch (SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }
}
