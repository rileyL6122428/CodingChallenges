package com.manifest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.manifest.server.model", "com.manifest.server.controller" })
@EnableJpaRepositories(basePackages = { "com.manifest.server.repository" })
public class CodeEvalCloneApplication {
	public static void main(String[] args) {
		SpringApplication.run(CodeEvalCloneApplication.class, args);
	}
}
