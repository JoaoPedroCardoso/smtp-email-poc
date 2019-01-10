package com.poc.smtp.email.service;

import com.poc.smtp.email.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${spring.mail.username}")
    private String sender;

    @Value("${email.subject}")
    private String subject;

    @Override
    public void sendConsumeConfirmationEmail (User obj) {
        SimpleMailMessage msg = prepareSimpleMailMessageFromConsume(obj);
        sendEmail(msg);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromConsume(User obj) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(obj.getEmail());
        msg.setFrom(this.sender);
        msg.setSubject(subject);
        msg.setSentDate(new Date(System.currentTimeMillis()));
        msg.setText(obj.toString());
        return msg;
    }

}