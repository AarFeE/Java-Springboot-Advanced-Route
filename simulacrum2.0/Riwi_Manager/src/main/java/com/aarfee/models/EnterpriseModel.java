package com.aarfee.models;

import com.aarfee.entities.EnterpriseEntity;
import com.aarfee.persistance.configDB.MySQLConfig;
import com.aarfee.persistance.imodel.IEnterpriseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseModel implements IEnterpriseModel {
    @Override
    public void create(EnterpriseEntity req) {
        Connection connection = MySQLConfig.openConnection();
        String query = "INSERT INTO Enterprise(name, nit) VALUES (?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getNit());

            preparedStatement.execute();

            System.out.println("Enterprise Correctly Created!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public EnterpriseEntity readById(Integer id) {
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Enterprise WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {

                return new EnterpriseEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("nit"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL ERROR: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
        return null;
    }

    @Override
    public List<EnterpriseEntity> readAll() {
        List<EnterpriseEntity> enterprises = new ArrayList<>();
        Connection connection = MySQLConfig.openConnection();

        String query = "SELECT * FROM Enterprise";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EnterpriseEntity addEnterprise = new EnterpriseEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("nit")
                );

                enterprises.add(addEnterprise);
            }

            return enterprises;
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    public void update(EnterpriseEntity req, Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "UPDATE Enterprise SET name = ?, nit = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getName());
            preparedStatement.setString(2, req.getNit());
            preparedStatement.setInt(3, id);

            preparedStatement.execute();

            System.out.println("Enterprise Correctly Updated!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = MySQLConfig.openConnection();
        String query = "DELETE FROM Enterprise WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            System.out.println("Enterprise Correctly Deleted!");
        } catch(SQLException e) {
            throw new RuntimeException("SQL Error: " + e.getMessage());
        } finally {
            MySQLConfig.closeConnection();
        }
    }

}
