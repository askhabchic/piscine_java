package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> socializedRooms;

    public User(long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> socRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.socializedRooms = socRooms;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void seetId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(createdRooms, user.createdRooms) && Objects.equals(socializedRooms, user.socializedRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, socializedRooms);
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", login='" + login + "\', password='" + password + "\', createdRooms=" + createdRooms + ", socializedRooms=" + socializedRooms + "}";
    }
}