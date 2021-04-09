package com.rabbit.consumer.interfaceDAO;

import com.rabbit.consumer.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepo extends CrudRepository<Message, Integer>{
}
