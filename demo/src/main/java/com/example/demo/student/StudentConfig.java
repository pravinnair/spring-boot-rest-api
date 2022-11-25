package com.example.demo.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student manny = new Student(
                    "Manny",
                    "manny@gmail.com",
                    LocalDate.of(2000,1,12)
            );
            Student tommy = new Student(
                    "Tommy",
                    "tommy@gmail.com",
                    LocalDate.of(1990,12,31)
            );
            repository.saveAll(List.of(manny,tommy));
        };
    }
}
