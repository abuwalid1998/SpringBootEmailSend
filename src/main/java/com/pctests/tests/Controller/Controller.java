package com.pctests.tests.Controller;


import com.pctests.tests.Models.Message;
import com.pctests.tests.Services.EmailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendemail")
public class Controller {


    final
    EmailSender emailSender;


    public Controller(EmailSender emailSender) {
        this.emailSender = emailSender;
    }


    @GetMapping("/set")
    public JavaMailSender getsetting(){
        return emailSender.getJavaMailSender();
    }


    @GetMapping("/send")
    public String SendEmail(
            @RequestBody Message message
            ){
        return emailSender.sendSimpleMessage(message);
    }


}
