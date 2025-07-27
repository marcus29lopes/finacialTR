package com.app.financialTR.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmail(String to, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Bem-vindo ao FinancialTR!");
        message.setText("Olá " + name + ",\n\nObrigado por se cadastrar na nossa plataforma!\n\nEquipe FinancialTR");
        mailSender.send(message);
    }

    public void sendPasswordReset(String to, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Redefinição de senha");
        message.setText("Clique no link para redefinir sua senha: " + resetLink);

        mailSender.send(message);
    }

}


