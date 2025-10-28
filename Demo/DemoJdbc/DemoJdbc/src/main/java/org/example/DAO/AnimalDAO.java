package org.example.DAO;

import org.example.entity.Animal;
import org.example.util.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    private Connection connection;
    private String request;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public Animal save (Animal animal) throws SQLException{
        try {
            connection = DatabaseManager.getConnection();
            request = "INSERT INTO animal (name,race,description,habitat,age) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,animal.getName());
            statement.setString(2,animal.getRace());
            statement.setString(3,animal.getDescription());
            statement.setString(4, animal.getHabitat());
            statement.setInt(5,animal.getAge());

            int row = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            if(row != 1){
                connection.rollback();
                return null;
            }

            if(resultSet.next()){
                animal.setId(resultSet.getInt(1));
            }
            connection.commit();
            return animal;
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
            connection.rollback();
            return null;
        }finally {
            connection.close();
        }
    }

    public List<Animal> get()throws SQLException{
        try {
            List<Animal> animals =new ArrayList<>();
            connection = DatabaseManager.getConnection();
            request = "SELECT * FROM animal";
            statement = connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                animals.add(Animal.builder()
                                .id(resultSet.getInt("id"))
                                .name(resultSet.getString("name"))
                                .race(resultSet.getString("race"))
                                .description(resultSet.getString("description"))
                                .habitat(resultSet.getString("habitat"))
                                .age(resultSet.getInt("age"))
                        .build());
            }
            return animals;

        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            connection.close();
        }
    }
}
