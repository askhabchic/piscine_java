package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {
        private JdbcTemplate jdbcTemplate;

        @Autowired
        public UsersRepositoryImpl(DataSource ds) {
            this.jdbcTemplate = new JdbcTemplate(ds);
        }

        @Override
        public User findById(Long id) {
            String query = "SELECT * FROM users WHERE id = " + id + ";";
            return jdbcTemplate.queryForObject(query, (rs, rowNum) ->
                    new User(rs.getLong(1), rs.getString(2), rs.getString(3)));
        }

        @Override
        public List<User> findAll() {
            return jdbcTemplate.query("SELECT * FROM users;",
                    (rs, rowNum) -> new User(rs.getLong("id"),
                            rs.getString("username"), rs.getString("password")));
        }

        @Override
        public void save(User entity) {
            jdbcTemplate.update("INSERT INTO users (id, username, password) VALUES (?, ?);", entity.getId(), entity.getUsername(), entity.getPassword());
        }

        @Override
        public void update(User entity) {
            jdbcTemplate.update("UPDATE users SET \"username\" = ?, \"password\" = ?, WHERE id = ?;", entity.getUsername(), entity.getPassword(), entity.getId());
        }

        @Override
        public void delete(Long id) {
            jdbcTemplate.update("DELETE FROM users WHERE id = ?;", id);
        }


    @Override
        public Optional<User> findByUsername(String username) {
            User user = jdbcTemplate.query("SELECT * FROM users WHERE \"username\" = ?;",
                    (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2), rs.getString(3)),
                    new Object[]{username}).stream().findAny().orElse(null);
            return Optional.of(user);
        }
}
