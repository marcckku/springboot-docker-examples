package docker.simple.example.controler;

import docker.simple.example.controler.dto.HelloWordl;
import lombok.Builder;
import lombok.Data;
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
public class TestController {
/*u7*/
    @GetMapping("/hello")
    public ResponseEntity<Object> test() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        log.info("GET HOST NAME {} ", ip.getHostName());
        log.info("GET HOST NAME ADDRESS {} ", ip.getHostAddress());
      return  ResponseEntity.ok(HelloWordl.builder().saluto("CIAO MONDO").ip(ip.getHostAddress()).hostName(ip.getHostName()).build());
    }
}
