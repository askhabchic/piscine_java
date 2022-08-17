package edu.school21.chat.repositories;


import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;
import edu.school21.chat.models.User;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private DataSource ds;
    private static String QUERY = "SELECT * FROM chat.msgs WHERE id=";

    public MessagesRepositoryJdbcImpl(HikariDataSource dataSource) {
        this.ds = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) {
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
            Chatroom room = new Chatroom(1L, "chatroom", user, null);
            Message message = new Message(rs.getLong("id"), user, room, rs.getString("text"), LocalDateTime.now());
            optionalMessage = Optional.of(message);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
        return optionalMessage;
    }

    @Override
    public void save(Message mess) {
        String query = "INSERT INTO chat.msgs (author, room, text, time) VALUES (" +
                mess.getRoom().getId() + ", " + mess.getAuthor().getId() +
                ", \'" + mess.getMessage() + "\', \'" + mess.getDate() + "\');";
        ResultSet rs = null;
        try (Connection conn = ds.getConnection();
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.execute();
                rs = statement.getGeneratedKeys();
                rs.next();
                mess.setId(rs.getLong(1));
            } catch (SQLException e) {
                throw new NotSavedSubEntityException("Author/room have no ID existing");
            }
        }

    @Override
    public void update(Message mess) {
//        String query = "UPDATE chat.msgs " +
//                "SET author = ?, " +
//                "room = ?, " +
//                "text = '?', " +
//                "time = " + "'" + mess.getDate() + "' WHERE id = ?;";
        String query = "UPDATE chat.msgs SET \"author\" = ?, \"room\" = ?, \"text\" = ?, \"time\" = ? WHERE id = ?;";
        try (Connection conn = ds.getConnection();
            PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setLong(1, mess.getRoom().getId());
            statement.setLong(2, mess.getAuthor().getId());
            statement.setString(3, mess.getMessage());
            try {
                statement.setTimestamp(4, Timestamp.valueOf(mess.getDate()));
            } catch (NullPointerException e) {
                statement.setTimestamp(4, null);
            }
            statement.setLong(5, mess.getId());

            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

