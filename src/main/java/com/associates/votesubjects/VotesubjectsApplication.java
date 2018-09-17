package com.associates.votesubjects;

import com.associates.votesubjects.repositories.VoteResultRepository;
import com.associates.votesubjects.repositories.VoteResultRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.associates.votesubjects")
@EnableMongoRepositories(basePackages = "com.associates.votesubjects.repositories")
@SpringBootApplication
public class VotesubjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotesubjectsApplication.class, args);
	}

	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener() {
		return new ValidatingMongoEventListener(validator());
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public VoteResultRepository voteResultRepository(final MongoTemplate mongoTemplate) {
		return new VoteResultRepositoryImpl(mongoTemplate);
	}
}
