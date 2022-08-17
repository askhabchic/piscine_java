package repositories;

import models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {
    private DataSource ds;

    public ProductsRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Product> findAll() {
    String query = "SELECT * FROM products;";
    List<Product> products =new ArrayList<>();
    try (Connection conn = ds.getConnection();
         Statement statement = conn.createStatement()) {
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Product product = new Product(rs.getLong("id"), rs.getString("name"), rs.getInt("price"));
            products.add(product);
        }
        return products;
    } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {
        Connection conn = ds.getConnection();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM products WHERE id = " + id + ";";
        ResultSet rs = statement.executeQuery(query);
        if (!rs.next())
            throw new RuntimeException(("Product with this ID not found"));
        Product product = new Product(rs.getLong(1), rs.getString(2), rs.getInt(3));
        statement.close();
        conn.close();
        return Optional.of(product);
    }

    @Override
    public void update(Product product) {
        String query = "UPDATE products SET \"name\" = ?, \"price\" = ?, WHERE id = ?;";
        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setLong(3, product.getId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void save(Product product) {
        String query = "INSERT INTO products (name, price) VALUES (?, ?);";
        ResultSet rs = null;
        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM products WHERE id = ?;";
        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
