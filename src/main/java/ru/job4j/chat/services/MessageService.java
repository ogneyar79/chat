package ru.job4j.chat.services;

import ru.job4j.chat.model.Message;
import ru.job4j.chat.model.Person;
import ru.job4j.chat.model.Room;

public class MessageService {

    private final Room room;
    public MessageService(Room room) {
        this.room = room;
    }


    public Message save(Message message)
         {
             return this.room.addMessageToRoom(message);
         }

}
