package docker.compose.example.controller;


public record MessageDto (
         String msg,
         String ip,
         String hostname
) { }
