package edu.school21.chat.app;

import java.io.IOException;
import java.sql.Connection;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.io.File;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.NotSavedSubEntityException;

public class Program {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_SCHEMA = "/resources/schema.sql";
    private static final String DB_DATA = "/resources/data.sql";
    private static final String DB_PATH = System.getenv("PWD") + "/Chat/src/main/";
    private static Connection connection;
    private static HikariDataSource ds;

    public static void main(String[] args) throws IOException, SQLException {
        connection = newConnection();
        runQuery(DB_SCHEMA);
        runQuery(DB_DATA);

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
        Optional<Message> messageOptional = messagesRepository.findById(1L);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDateTime(null);
            messagesRepository.update(message);
            System.out.println("MessagesRepository updated");
        } else if (!messageOptional.isPresent()) {
            System.out.println("Failed");
        }
    }

    public static void runQuery(String file) {
        try {
            Scanner sc = new Scanner(new File(DB_PATH + file)).useDelimiter(";");
            try {
                Statement statement = connection.createStatement();
                while (sc.hasNext()) {
                    statement.execute(sc.next().trim());
                }
                statement.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static Connection newConnection() throws IOException, SQLException {
        Connection con = null;
        ds = createDataSource();
        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public static HikariDataSource createDataSource() throws IOException, SQLException {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(DB_USERNAME);
        config.setPassword(DB_PASSWORD);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        return new HikariDataSource(config);
    }
}
