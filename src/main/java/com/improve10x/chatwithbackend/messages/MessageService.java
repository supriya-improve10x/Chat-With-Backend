package com.improve10x.chatwithbackend.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageService {

    @Autowired
    MessagesDbManager messagesDbManager;

    public List<Message> getMessages(){
        return messagesDbManager.getMessages();
    }
}
