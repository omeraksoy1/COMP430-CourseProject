package com.Project.backend;

import com.Project.backend.service.BudgetService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan("com.Project.backend")
@EnableJpaRepositories("com.Project.backend.repository")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean(name = "bean1")
	public BudgetService budgetService(){
		return new BudgetService();
	}

}
