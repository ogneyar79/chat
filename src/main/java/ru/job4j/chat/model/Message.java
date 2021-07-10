package ru.job4j.chat.model;

import java.sql.Timestamp;

public class Message {

    Long id;
    // автор сообщения должно быть уникальным, если null - автор сервер
    public String userName;
    // время сообщения
    public Timestamp dataCreated;
    // текст сообщения
    public String report = "";



    public Message() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(Timestamp dataCreated) {
        this.dataCreated = dataCreated;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
