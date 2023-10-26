package dev.zuhayr.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
public class MoviesApplication {

	public static void main(String[] args) {   // the server runs on http://localhost:8080/api/v1/movies
		SpringApplication.run(MoviesApplication.class, args);
	}

//	@GetMapping("/")   // it leads the framework to know that this method below is a get end point
//	public String apiRoot() {
//		return "Hello World!";
//	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}

}
