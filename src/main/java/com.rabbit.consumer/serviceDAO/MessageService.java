package com.rabbit.consumer.serviceDAO;

import java.util.ArrayList;
import java.util.List;

import com.rabbit.consumer.interfaceDAO.MessageRepo;
import com.rabbit.consumer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepo repository;

    //Save into H2 db
    public void save(final Message message) {
        repository.save(message);
    }

    public List<Message> getAll() {
        final List<Message> messages = new ArrayList<>();
        repository.findAll().forEach(message -> messages.add(message));
        return messages;
    }

    public Message getMessageById(int id){
        return repository.findById(id).get();
    }
}