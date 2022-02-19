package com.example.demo.assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AssignmentConfig {
    @Bean
    CommandLineRunner commandLineRunnerAssignment(AssignmentRepository repository) {
        return args -> {
            Assignment aTaleOfTwoCitiesBookReport = new Assignment("A Tale of Two Cities: Book Report");
            Assignment romeoAndJulietBookReport = new Assignment("Romeo and Juliet: Book Report");
            repository.saveAll(List.of(aTaleOfTwoCitiesBookReport, romeoAndJulietBookReport));
        };
    }
}
