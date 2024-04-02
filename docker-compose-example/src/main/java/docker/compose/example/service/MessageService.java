package docker.compose.example.service;

import docker.compose.example.controler.dto.MessageDto;
import docker.compose.example.model.Message;
import docker.compose.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public void insertMessage(MessageDto messageDto) {
        repository.save(Message.builder().ip(messageDto.getIp())
                .hostName(messageDto.getHostName()).msg(messageDto.getMsg()).build());
    }

}
