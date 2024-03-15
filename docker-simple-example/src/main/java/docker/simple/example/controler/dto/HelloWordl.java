package docker.simple.example.controler.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloWordl{
    private String saluto;
    private String hostName;
    private String ip;
}