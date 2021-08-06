package org.danyuan.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

/**
 * Main class of application<br>
 * 
 * Spring Boot tries to guess the location of your {@link Repository}, based on
 * the {@link EnableAutoConfiguration} annotation it finds. So we have to place
 * {@link EnableJpaRepositories} annotation below {@link SpringBootApplication}
 * annotation
 * 
 * @author Wenbo Wang (jackie-1685@163.com)
 * 
 */

@SpringBootApplication
public class Application {

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
	}

}
