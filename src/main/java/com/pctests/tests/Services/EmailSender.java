package com.pctests.tests.Services;


import com.pctests.tests.Models.Message;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Properties;


@Service
public class EmailSender implements Serializable {

    private JavaMailSender emailSender;

    public EmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public JavaMailSender getJavaMailSender() {

        try {

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);

            mailSender.setUsername("amjadkhaliliah1998@gmail.com");
            mailSender.setPassword("181512@Aa");

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");


            return mailSender;
        }catch (Exception e){

            System.out.println("**********************************");
            System.out.println(e.getMessage());

            return null;
        }

    }

    public String sendSimpleMessage(Message mymessage) {

        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@baeldung.com");
            message.setTo(mymessage.getTo());
            message.setSubject(mymessage.getSubject());
            message.setText(mymessage.getText());
            emailSender.send(message);

            return "Email Sent Successfully";

        }catch (Exception e){
            return e.toString();
        }


    }


}
