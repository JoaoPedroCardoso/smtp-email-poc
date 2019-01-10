package com.poc.smtp.email.controller;

import com.poc.smtp.email.service.EmailService;
import com.poc.smtp.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    @Autowired
    private EmailService mailService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method= RequestMethod.POST)
    public ResponseEntity<Void> sendMail(@PathVariable Long id){
        mailService.sendConsumeConfirmationEmail(userService.findById(id));
        return ResponseEntity.ok().build();
    }

}
