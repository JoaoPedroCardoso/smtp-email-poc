package com.poc.smtp.email.service;

import com.poc.smtp.email.EmailApplicationTests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

public class SmtpEmailServiceTest extends EmailApplicationTests {

    @InjectMocks
    private SmtpEmailService emailService;

    @Mock
    private MailSender mailSender;

    @BeforeAll
    public static void BeforeClass(){
        MockitoAnnotations.initMocks(SmtpEmailServiceTest.class);
        mock(SmtpEmailService.class);
    }

    @Test
    @DisplayName("should send mail without exception")
    public void shouldSendMailTest() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("teste@hotmail.com");
        msg.setFrom("test@gmail.com");
        msg.setSubject("Test");
        msg.setSentDate(new Date(System.currentTimeMillis()));
        msg.setText("Test");
        assertDoesNotThrow(() -> emailService.sendEmail(msg));
    }

}
