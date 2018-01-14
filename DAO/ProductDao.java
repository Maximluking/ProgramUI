package DAO;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private Connection connection;

    public ProductDao() {
        try {
            Class.forName ("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS products " +
                    "(id INT(10) NOT NULL IDENTITY(1,1) PRIMARY KEY, name VARCHAR(20) NOT NULL, " +
                    "number INT(10) NOT NULL, value INT(10) NOT NULL, " +
                    "weight INT(10) NOT NULL," +
                    "volume INT(10) NOT NULL);");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        try (PreparedStatement ps = connection.prepareStatement("insert into products (name, number, value, weight, volume) values(? ,?, ?, ?, ?)")
        ) {
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getProductNumber());
            ps.setInt(3, product.getProductValue());
            ps.setInt(4, product.getProductWeight());
            ps.setInt(5, product.getProductVolume());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAll() {
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM products")
        ) {

            ResultSet resultSet = ps.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int number = resultSet.getInt("number");
                int value = resultSet.getInt("value");
                int weight = resultSet.getInt("weight");
                int volume = resultSet.getInt("volume");
                products.add(new Product(id, name, number, value, weight, volume));
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void updateProduct(Product product) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE products SET name = ?, number = ?, value = ?, weight = ?, volume = ? WHERE id = ?")) {

            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getProductNumber());
            ps.setInt(3, product.getProductValue());
            ps.setInt(4, product.getProductWeight());
            ps.setInt(5, product.getProductVolume());
            ps.setLong(6, product.getProductId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void removeProduct(int id){
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM products WHERE id = ?")){
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findProduct(String findParam, String param){
        switch (findParam) {
            case "1":
                try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM products WHERE ID = " + Integer.valueOf(param))) {
                    ResultSet resultSet = ps.executeQuery();
                    List<Product> products = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int number = resultSet.getInt("number");
                        int value = resultSet.getInt("value");
                        int weight = resultSet.getInt("weight");
                        int volume = resultSet.getInt("volume");
                        products.add(new Product(id, name, number, value, weight, volume));
                    }
                    for(Product product: products){
                        System.out.println(product.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM products WHERE NAME LIKE '" + param + "%'")) {
                    ResultSet resultSet = ps.executeQuery();
                    List<Product> products = new ArrayList<>();
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int number = resultSet.getInt("number");
                        int value = resultSet.getInt("value");
                        int weight = resultSet.getInt("weight");
                        int volume = resultSet.getInt("volume");
                        products.add(new Product(id, name, number, value, weight, volume));
                    }
                    for(Product product: products){
                        System.out.println(product.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
