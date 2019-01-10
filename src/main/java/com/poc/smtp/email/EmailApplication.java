package com.poc.smtp.email;

import com.poc.smtp.email.service.EmailService;
import com.poc.smtp.email.service.SmtpEmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailApplication {

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

}

