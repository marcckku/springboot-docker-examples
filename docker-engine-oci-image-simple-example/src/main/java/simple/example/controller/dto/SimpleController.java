package simple.example.controller.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RestController
@RequestMapping("api/")
public class SimpleController {
    @GetMapping("/ip")
    public ResponseEntity<Object> getIp() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        log.info("GET HOST NAME {} ", ip.getHostName());
        log.info("GET HOST NAME ADDRESS {} ", ip.getHostAddress());
        return ResponseEntity.ok(HelloWorld.builder().greetings("Hello World!!")
                .ip(ip.getHostAddress()).hostName(ip.getHostName()).build());
    }
}
