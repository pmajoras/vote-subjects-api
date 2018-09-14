package com.associates.votesubjects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan("com.associates.votesubjects")
@EnableMongoRepositories(basePackages = "com.associates.votesubjects.repositories")
@SpringBootApplication
public class VotesubjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotesubjectsApplication.class, args);
	}
}
