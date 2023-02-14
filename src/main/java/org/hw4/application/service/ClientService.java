package org.hw4.application.service;

import org.hw4.application.entity.Client;
import static org.hw4.application.storage.DataSource.getInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClientService {

    public long create(String name) {
        try(Connection connection = getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO client(name) VALUES(?)")) {
            preparedStatement.setString(1, name);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getById(int id){
        try(Connection connection = getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT name FROM client WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                return resultSet.getString("name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    public void setName(int id, String name){
        try(Connection connection = getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE client SET name = ? WHERE id = ?")) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id){
        try(Connection connection = getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM client WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> listAll(){
        List<Client> clients = new LinkedList<>();
        try(Connection connection = getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM client")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                clients.add(new Client(resultSet.getInt("id"), resultSet.getString("name")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

}
