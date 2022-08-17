package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private DataSource ds;

    public UsersRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String query = "SELECT * FROM users WHERE \"email\" = ?;";
        User user = null;
        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet rs = statement.executeQuery();
            if (!rs.next())
                throw new RuntimeException("User with this email not found");
            user = new User(rs.getLong("id"), rs.getString("email"));
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return Optional.of(user);
    }

    @Override
    public User findById(Long id) {
        try (Connection conn = ds.getConnection();
             Statement statement = conn.createStatement()) {
            String query = "SELECT * FROM users WHERE id = " + id + ";";
            ResultSet rs = statement.executeQuery(query);
            if (!rs.next())
                throw new RuntimeException("User with this ID not found");
            User user = new User(rs.getLong(1), rs.getString("email"));
            return user;
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM users;";
        List<User> users = new ArrayList<>();
        try (Connection conn = ds.getConnection();
        Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                User user = new User(rs.getLong("id"), rs.getString("email"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void save(User entity) {
        String query = "INSERT INTO users (id, email) VALUES (?, ?);";
        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    @Override
    public void update(User entity) {
        String query = "UPDATE users SET \"email\" = ?, WHERE id = ?;";
        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getEmail());
            statement.setLong(2, entity.getId());
            statement.execute();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM users WHERE id = ?;";
        try (Connection conn = ds.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
