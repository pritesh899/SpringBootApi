package com.pritesh.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.pritesh.api.config.SwaggerConfig;
import com.pritesh.api.config.WebConfig;

@SpringBootApplication
@Import({ WebConfig.class, SwaggerConfig.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
