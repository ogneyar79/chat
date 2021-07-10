package ru.job4j.chat.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.services.MessageService;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private static Logger log = Logger.getLogger(MessageController.class.getName());

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.POST, value = {"/message"})
    public void saveMessageToChat(@RequestBody Message m) {
        log.info(" try to get message from user and send to chat 24 ");
        m.setId(0L);
        m.setDataCreated(new Timestamp(System.currentTimeMillis()));
        log.info(" We got message from ajax:" + m + "27;");
        messageService.save(m);
        log.info(" We try to get all message saveMethodToChat from base size 30:" +   messageService.findAllMessage().size());
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/mes"})
    public Message getExperimentMessage() {
        log.info(" Expirement");
        Message message1 = new Message();
        message1.setId(0l);
        message1.setUserName("JSON_User");
        message1.setDataCreated(new Timestamp(System.currentTimeMillis()));
        message1.setReport("Expirement");
        return message1;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/get_mes"})
    public List<Message> getAllMessage() {
        log.info("Get All Message 42");
        log.info(" We try to get all message from base size 53:" +   messageService.findAllMessage().size());
        return messageService.findAllMessage();
    }


}
