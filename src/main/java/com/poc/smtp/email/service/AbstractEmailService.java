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
    public void sendUserConfirmationEmail(User obj) {
        SimpleMailMessage msg = prepareSimpleMailMessageFromUser(obj);
        sendEmail(msg);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromUser(User obj) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(obj.getEmail());
        msg.setFrom(this.sender);
        msg.setSubject(subject);
        msg.setSentDate(new Date(System.currentTimeMillis()));
        msg.setText(obj.toString());
        return msg;
    }

}