package docker.compose.example.controler;

import docker.compose.example.controler.dto.MessageDto;
import docker.compose.example.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api")
@Slf4j
public class MessageController {

    private MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/ip")
    public ResponseEntity<Object> getMessage() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        log.info("GET HOST NAME {} ", ip.getHostName());
        log.info("GET HOST NAME ADDRESS {} ", ip.getHostAddress());
        MessageDto messageDto = MessageDto.builder().msg("Congratulations!!").ip(ip.getHostAddress()).hostName(ip.getHostName()).build();
        service.insertMessage(messageDto);
        return ResponseEntity.ok(messageDto);
    }
}
