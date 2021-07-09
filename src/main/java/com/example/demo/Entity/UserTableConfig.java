package com.example.demo.Entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserTableConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserTableRepository userTableRepository) {

        return args -> {
            UserTable tugcan = new UserTable(
                    1L,
                    "Tugcan",
                    "1234"
            );
            UserTable osman = new UserTable(
                    2L,
                    "Osman",
                    "12345"

            );

            userTableRepository.saveAll(
                    List.of(tugcan, osman)
            );

        };

    }
}
