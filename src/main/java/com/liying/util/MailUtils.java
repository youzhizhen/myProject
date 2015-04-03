package com.liying.util;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailUtils {
 
    public void sendPreConfiguredMail(String message) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("1030371145@qq.com");
        mailSender.setPassword("liying890424");
        mailSender.setDefaultEncoding("UTF-8");
        mailSender.setPort(465);
        Properties pros = mailSender.getJavaMailProperties();
        pros.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pros.setProperty("mail.smtp.socketFactory.fallback", "false");
        pros.setProperty("mail.smtp.auth", "true");
        pros.setProperty("mail.smtp.timeout", "5000");
        mailSender.setJavaMailProperties(pros);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("1030371145@qq.com");
        mailMessage.setFrom("1030371145@qq.com");
        mailMessage.setSubject("Test");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
    
    public static void main(String[] args) {
        MailUtils mailer = new MailUtils();
        mailer.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
        System.out.println("sccuess!");

    }
}
