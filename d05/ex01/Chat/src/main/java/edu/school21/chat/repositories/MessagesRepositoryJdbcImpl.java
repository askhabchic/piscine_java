package edu.school21.chat.repositories;


import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;
import edu.school21.chat.models.User;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private DataSource ds;
    private static String QUERY = "SELECT * FROM chat.msgs WHERE id=";

    public MessagesRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.ds = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage = null;
        ResultSet rs = null;
        try {
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            String query = QUERY + id;
            rs = statement.executeQuery(query);
            if (!rs.next())
                return Optional.empty();
            User user = new User(1L, "fhyman", "password", null, null);
            Chatroom room = new Chatroom(1L, "chatroom", user);
            Message message = new Message(rs.getInt("id"), user, room, rs.getString("text"), LocalDateTime.now());
            optionalMessage = Optional.of(message);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return optionalMessage;
    }
}
