package com.m7tar.runnerz;

import com.m7tar.runnerz.run.Location;
import com.m7tar.runnerz.run.Run;
import foo.bar.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	//this is a logger, can you believe it?
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		//our main java method
		SpringApplication.run(Application.class, args);
		//this class is outside the default package which is com.m7tar.runners
		var WM = new WelcomeMessage();
		System.out.println(WM.getwelcomeMessage());
		log.info("Application has started successfully");
		/*
		//this is for getting classes that reside inside the default package wssup
		ConfigurableApplicationContext context = SpringApplication.run(RunnerzApplication.class, args);
		GoodbyeMessage GM = (GoodbyeMessage) context.getBean("goodbyeMessage");
		System.out.println(GM.getGoodbyeMessage());
		 */

		/*
		//this dosent work, why?
		WelcomeMessage WM = (WelcomeMessage) context.getBean("welcomeMessage");
		System.out.println(WM.getwelcomeMessage());
		 */

	}
	//this is a command line runner. it runs after the application has started and after the application context has been created.
	@Bean
	CommandLineRunner runner() {
		return args -> {
			//Run run = new Run(3, "myRun", LocalDateTime.now(), LocalDateTime.now().plusHours(4), 4, Location.INDOOR);
		};
    }
}


// use jps to see whats running on what port.
// you can run using maven also:
	// ./mvnw spring-boot:run
