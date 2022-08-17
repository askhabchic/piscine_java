package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> listOfMessages;

    public Chatroom(Long id, String name, User owner, List<Message> list) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.listOfMessages = list;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Chatroom chat = (Chatroom) o;
        return id == chat.id && name.equals(chat.name) && owner.equals(chat.owner) && listOfMessages.equals(chat.listOfMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, listOfMessages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", listOfMessages=" + listOfMessages +
                '}';
    }
}