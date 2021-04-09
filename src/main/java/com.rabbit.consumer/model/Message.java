package com.rabbit.consumer.model;

import javax.persistence.*;

@Entity
@Table
public class Message {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String content;

    public Message(){}

    public Message(int id ,String content){
        this.id = id;
        this.content = content;
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


    @Override
    public String toString() {
        return "message{" +
                "key='" + content + '\'' +
                '}';
    }
}
