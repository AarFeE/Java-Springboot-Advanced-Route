package com.aarfee.models;

import com.aarfee.entities.CoderEntity;
import com.aarfee.persistance.configDB.MySQLConfig;
import com.aarfee.persistance.imodel.ICoderModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements ICoderModel {
    @Override
    public void create(CoderEntity req) {
        Connection connection = MySQLConfig.openConnection();
        String query = "INSERT INTO Coder(name, last_name, clan, documentation) VALUES (?,?,?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getLastName());
            preparedStatement.setString(3, req.getClan());
            preparedStatement.setString(4, req.getDocumentation());

            preparedStatement.execute();

            System.out.println("Coder Correctly Created!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public CoderEntity readById(Integer id) {
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Coder WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                return new CoderEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("documentation"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("clan"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return null;
    }

    @Override
    public List<CoderEntity> readAll() {
        List<CoderEntity> coders = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Coder";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CoderEntity addCoder = new CoderEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("documentation"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("clan"));

                coders.add(addCoder);
            }

            return coders;
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void update(CoderEntity req, Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Coder SET name = ?, last_name = ?, clan = ?, documentation = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getLastName());
            preparedStatement.setString(3, req.getClan());
            preparedStatement.setString(4, req.getDocumentation());
            preparedStatement.setInt(5, id);

            preparedStatement.execute();

            System.out.println("Coder Correctly Updated!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "DELETE FROM Coder WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            System.out.println("Coder Correctly Deleted!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }
}

