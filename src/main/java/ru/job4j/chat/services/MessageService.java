package ru.job4j.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.model.Room;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private final Room room;

    public MessageService(Room room) {
        this.room = room;
    }


    public Message save(Message message) {
        return this.room.addMessageToRoom(message);
    }

    public List<Message> findAllMessage() {
        return this.room.findMessage();
    }

    public Room getRoom() {
        return room;
    }
}
