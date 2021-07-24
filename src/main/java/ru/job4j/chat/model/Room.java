package ru.job4j.chat.model;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Room {

    private long id;
    private String name;

    public List<User> users;  // Все пользователи чата

    public List<Message> messages; // все сообщения

    public Room() {
        if (users == null) {
            users = new ArrayList<>();
        }
        if (messages == null) {
            messages = new ArrayList<>();
            Message message = new Message();
            message.setUserName("Robot");
            message.setDataCreated(new Timestamp(System.currentTimeMillis()));
            message.setReport("Chat start");
            messages.add(message);
        }
    }

    public List<Message> findMessage() {
        return this.messages;
    }

    public User addPersonToRoom(User user) {
        this.users.add(user);
        return user;
    }

    public Message addMessageToRoom(Message message) {
        this.messages.add(message);
        return message;
    }

}
