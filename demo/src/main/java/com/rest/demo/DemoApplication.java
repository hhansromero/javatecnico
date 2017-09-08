package com.rest.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.rest.demo.domain.User;
import com.rest.demo.repository.UserRepository;

@SpringBootApplication
@ComponentScan ({"com.rest.demo.controller", "com.rest.demo.domain","com.rest.demo.service","com.rest.demo.request"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(UserRepository userRepository){
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				List<String> users=new ArrayList<>();
				users.add("Balerio");
				users.add("Cazulo");
				users.add("Bonnet");
				users.forEach(item->{
					userRepository.save(new User(item));
				});
				
//				jobLoggerRepository.save(new JobLogger("First message", LoggerType.WARNING));
				
				userRepository.findAll().forEach(item->{
					System.out.println("User: "+ item.getId()+"-"+item.getName());
				});
				
//				jobLoggerRepository.findAll().forEach(item->{
//					System.out.println("Message: "+ item.getId()+"-"+item.getText());
//				});
				
			}
		};
	}
	
//	@Bean
//	HealthIndicator springBootLima(){
//		return new HealthIndicator() {
//			
//			@Override
//			public Health health() {
//				return Health.status("Hola Spring Boot Lima por Hans Romero")
//					.withDetail("timestamp", System.currentTimeMillis())
//					.build();
//			}
//		};
//		
//	}
}
