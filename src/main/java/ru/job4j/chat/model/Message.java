package ru.job4j.chat.model;

import java.sql.Timestamp;

public class Message {

    Long id;
    // автор сообщения должно быть уникальным, если null - автор сервер
    public String userName;
    // время сообщения
    public Timestamp createTime;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
