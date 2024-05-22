package simple.example.controller.dto;

import lombok.Builder;

@Builder
public record HelloWorld(
        String greetings,
        String hostName,
        String ip
) {}