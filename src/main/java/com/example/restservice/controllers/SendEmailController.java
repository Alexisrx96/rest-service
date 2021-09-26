package com.example.restservice.controllers;

import com.example.restservice.services.EmailSenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class SendEmailController {
/*
    @Autowired
    EmailSenderServices emailSenderServices;

    @PostMapping("send-email")
    public void sendEmail() throws MessagingException {
        emailSenderServices.sendEmail("yeshuab3@gmail.com","","Confirm Order","./src/main/resources/file.txt");
    }*/
}
