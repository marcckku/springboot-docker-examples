package docker.compose.example.controler.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
    private String msg;
    private String hostName;
    private String ip;
}