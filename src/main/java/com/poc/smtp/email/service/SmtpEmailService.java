package com.poc.smtp.email.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@Log
public class SmtpEmailService extends AbstractEmailService{

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendEmail(SimpleMailMessage msg) {
        log.info("Sending email...");
        mailSender.send(msg);
        log.info("Sended email");
    }

}
