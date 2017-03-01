package com.manifest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@EntityScan(basePackages = { "com.manifest.server.model", "com.manifest.server.controller", "com.manifest.server.services" })
@EnableJpaRepositories(basePackages = { "com.manifest.server.repository" })
public class CodeEvalCloneApplication {
	public static void main(String[] args) {
		SpringApplication.run(CodeEvalCloneApplication.class, args);
	}
}


