package docker.compose.example.controller;

import docker.compose.example.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("api/")
@Slf4j
public class MessageController {

    private MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping({"/ip"})
    public ResponseEntity<Object> getMessage() throws UnknownHostException {
        InetAddress localHostInfo = InetAddress.getLocalHost();
        log.info("GET HOST NAME {} ", localHostInfo.getHostName());
        log.info("GET HOST NAME ADDRESS {} ", localHostInfo.getHostAddress());
        MessageDto dto = new MessageDto("Localhost Info!!", localHostInfo.getHostAddress(), localHostInfo.getHostName());
        this.service.insertNewMessage(dto);
        return ResponseEntity.ok(dto);
    }

}
