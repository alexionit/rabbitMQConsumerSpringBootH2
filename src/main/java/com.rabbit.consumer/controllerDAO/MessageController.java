package com.rabbit.consumer.controllerDAO;

import java.util.List;
import javax.validation.Valid;
import com.rabbit.consumer.model.Message;
import com.rabbit.consumer.serviceDAO.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageService service;

    @PostMapping(value= "/message/save")
    public String save(final @RequestBody @Valid Message message) {
        log.info("Saving message details in the database.");
        service.save(message);
        return message.getContent();
    }

    @GetMapping(value= "/message/getall", produces= "application/vnd.jcg.api.v1+json")
    public List<Message> getAll() {
        log.info("Getting messages from the database.");
        return service.getAll();
    }

    @GetMapping("/message/getmessageid/{id}")
    private Message getMessage(@PathVariable("id") int id)
    {
        return service.getMessageById(id);
    }

//    @RequestMapping("/error")
//    public String handleError() {
//        return "<h1>Something went wrong!</h1>";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
}
