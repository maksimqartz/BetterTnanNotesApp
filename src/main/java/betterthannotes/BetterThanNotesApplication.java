package betterthannotes;

// Точка входа в Spring Boot
// Запускает встроенный сервер и инициализирует контекст Spring

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BetterThanNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetterThanNotesApplication.class, args);
    }
}