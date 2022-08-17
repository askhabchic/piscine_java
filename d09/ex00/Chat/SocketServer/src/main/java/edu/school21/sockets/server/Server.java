package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.models.User;
import edu.school21.sockets.services.UsersService;
import edu.school21.sockets.services.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private static BufferedReader reader = null;
    private static BufferedReader in = null;
    private static BufferedWriter out = null;
    AnnotationConfigApplicationContext context;
    private Integer port;
    private String username;
    private String password;

    public Server(Integer port) {
//        context = new AnnotationConfigApplicationContext((SocketsApplicationConfig.class));
        this.port = port;
    }

    public void run() {
//        UsersService usersService = context.getBean("usersService", UsersService.class);
        try {
                server = new ServerSocket(port);
                System.out.println("Server started");
                socket = server.accept();
                System.out.println("Client connected");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                reader = new BufferedReader(new InputStreamReader(System.in));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                out.write("Hello from Server!\n");
                out.flush();

                String clientMsg = in.readLine();
                System.out.println(clientMsg);
                out.write("Enter username:\n");
                out.flush();

                username = in.readLine();
                out.write("Enter password:\n");
                out.flush();

                password = in.readLine();
                ApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
                UsersService usServ = context.getBean(UsersService.class);
                if (usServ.signUp(username, password)) {
                    out.write("Successful!\n");
                } else {
                    out.write("User with this username already exists");
                }
                out.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    in.close();
                    socket.close();
                    server.close();
                    out.close();
                } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
