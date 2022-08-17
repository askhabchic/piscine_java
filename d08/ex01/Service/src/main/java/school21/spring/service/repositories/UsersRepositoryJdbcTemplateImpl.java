package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public User findById(Long id) {
        String query = "SELECT * FROM users WHERE id = " + id + ";";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) ->
                new User(rs.getLong(1), rs.getString(2)));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users;",
                (rs, rowNum) -> new User(rs.getLong("id"),
                        rs.getString("email")));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users (id, email) VALUES (?, ?);", entity.getId(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET \"email\" = ?, WHERE id = ?;", entity.getEmail(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?;", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = jdbcTemplate.query("SELECT * FROM users WHERE \"email\" = ?;",
                (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)),
                new Object[]{email}).stream().findAny().orElse(null);
        return Optional.of(user);
    }
}
