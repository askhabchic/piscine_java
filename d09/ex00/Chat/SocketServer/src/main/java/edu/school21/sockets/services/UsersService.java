package edu.school21.sockets.services;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public interface UsersService {
    boolean signUp(String user, String password);
}
