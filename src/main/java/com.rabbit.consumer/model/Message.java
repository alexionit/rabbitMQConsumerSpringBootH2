package com.rabbit.consumer.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "messages")
@Table
public class Message {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String content;

    @Column
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH.mm.ss", timezone="Europe/Berlin")
    private Timestamp timestamp;

    public Message(){}

    public Message(String content, Timestamp timestamp){
        this.content = content;
        this.timestamp = timestamp;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "message{" +
                "key='" + content + '\'' +
                '}';
    }
}
