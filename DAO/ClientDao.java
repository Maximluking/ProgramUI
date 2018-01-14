package DAO;

import model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private Connection connection;

    public ClientDao() {
        try {
            Class.forName ("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS clients" +
                    "(id INT(10) NOT NULL IDENTITY(1,1) PRIMARY KEY, name VARCHAR(20) NOT NULL," +
                    "surname VARCHAR(20) NOT NULL, age INT(3) NOT NULL);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO clients (name, surname, age) values(? ,?, ?)")){
            ps.setString(1, client.getClientName());
            ps.setString(2, client.getClientSurname());
            ps.setInt(3, client.getClientAge());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAll() {
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients")){
            ResultSet resultSet = ps.executeQuery();
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                clients.add(new Client(id, name, surname, age));
            }
            return clients;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void updateClient(Client client) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE clients SET name = ?, surname = ?, age = ? WHERE id = ?")){
            ps.setString(1, client.getClientName());
            ps.setString(2, client.getClientSurname());
            ps.setInt(3, client.getClientAge());
            ps.setLong(4, client.getClientId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeClient(int id){
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM clients WHERE id = ?")){
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findClient(String findParam, String param){
        switch (findParam) {
            case "1":
                try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients WHERE ID = " + Integer.valueOf(param))) {
                    ResultSet resultSet = ps.executeQuery();
                    List<Client> clients = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        int age = resultSet.getInt("age");
                        clients.add(new Client(id, name, surname, age));
                    }
                    for(Client client: clients){
                        System.out.println(client.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients WHERE NAME LIKE '" + param + "%'")) {
                    ResultSet resultSet = ps.executeQuery();
                    List<Client> clients = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        int age = resultSet.getInt("age");
                        clients.add(new Client(id, name, surname, age));
                    }
                    for(Client client: clients){
                        System.out.println(client.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "3":
                try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients WHERE SURNAME LIKE '" + param + "%'")) {
                    ResultSet resultSet = ps.executeQuery();
                    List<Client> clients = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        int age = resultSet.getInt("age");
                        clients.add(new Client(id, name, surname, age));
                    }
                    for(Client client: clients){
                        System.out.println(client.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "4":
                try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM clients WHERE age = " + Integer.valueOf(param))) {
                    ResultSet resultSet = ps.executeQuery();
                    List<Client> clients = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        int age = resultSet.getInt("age");
                        clients.add(new Client(id, name, surname, age));
                    }
                    for(Client client: clients){
                        System.out.println(client.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
