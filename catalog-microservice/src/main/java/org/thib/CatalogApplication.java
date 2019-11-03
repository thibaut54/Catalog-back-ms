package org.thib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.thib"})
@EntityScan(basePackages = {"org.thib"})
public class CatalogApplication {

	public static void main(String[] args) {

		SpringApplication.run( CatalogApplication.class, args );

	}

}
