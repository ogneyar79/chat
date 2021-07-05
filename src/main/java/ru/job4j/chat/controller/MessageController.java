package ru.job4j.chat.controller;


import org.springframework.web.bind.annotation.*;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.services.MessageService;

import java.sql.Timestamp;
import java.util.logging.Logger;

@RestController
@RequestMapping("/message")
public class MessageController {

    private static Logger log = Logger.getLogger(MessageController.class.getName());
    private MessageService messageService;

    @PostMapping("/")
    Message saveMessageToChat(@ModelAttribute Message m, @RequestBody Message message) {
        log.info(" try to get message from user and send to chat 17 ");
        m.setId(0L);
        m.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return messageService.save(m);
    }
}
