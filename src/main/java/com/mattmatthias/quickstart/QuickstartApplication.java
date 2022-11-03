package com.mattmatthias.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.*;

@SpringBootApplication
public class QuickstartApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(QuickstartApplication.class);
		application.run(args);

	}

}
