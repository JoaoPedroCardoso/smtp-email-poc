package com.poc.smtp.email.service;

import com.poc.smtp.email.domain.User;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendUserConfirmationEmail(User user);

    void sendEmail (SimpleMailMessage msg);
}
