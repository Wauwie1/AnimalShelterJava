package sample.Database;
import sample.Webshop.Product;
import sample.Webshop.Sellable;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseController {

    private FileInputStream input;
    private Connection connection = null;
    private String url;
    private String drivers;


    public DatabaseController() {
        connect();
        loadProductsFromDatabase();
    }

    private void connect() {

        try {
            input = new FileInputStream("db.prop");
            // load a properties file
            Properties prop = new Properties();

            try {
                prop.load(input);
            } catch (IOException exception) {
                System.out.println("Error occurred");
                System.out.println(exception);
            }
            drivers = prop.getProperty("jdbc.drivers");
            url = prop.getProperty("jdbc.url");

            Class.forName(drivers);

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public void saveToDatabase() {

    }

    public List<Product> loadProductsFromDatabase() {

        try {
            // create a database connection
            connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            // set timeout to 30 sec.
            statement.setQueryTimeout(30);

            List<Product> loadedProductsList = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT * FROM Products");
            while (rs.next()) {
                String productName = rs.getString("name");
                Double productPrice = rs.getDouble("price");

                Product product = new Product(productName, productPrice);
                loadedProductsList.add(product);
            }

            return loadedProductsList;
        } catch (SQLException exception) {
            System.out.println(exception);
            return null;
        }
    }
}