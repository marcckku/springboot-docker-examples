package docker.compose.example.service;

import docker.compose.example.controller.MessageDto;
import docker.compose.example.entity.Message;
import docker.compose.example.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageService {
    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public void insertNewMessage(MessageDto dto){
        log.info("New Message is now inserted!!..");
       repository.save(Message.builder().message(dto.msg()).hostName(dto.hostname()).ip(dto.ip()).build());
    }
}
