package edu.school21.sockets.app;

import edu.school21.sockets.server.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        if (!args[0].startsWith("--port="))
            System.err.println("Invalid argument");
        int port = Integer.parseInt(args[0].substring(args[0].indexOf("=") + 1));
        if (port <= 1024 || port > 60000)
            System.err.println("Invalid port");
        Server server = new Server(port);
        server.run();
    }
}
