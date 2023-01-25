# SpringBootEmailSend


For Application.proparties file use this configuration :

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<Your Email>
spring.mail.password=<Your Password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true




#This Configration is for Gmail Smtp Server 

#Below is the Req Body for sending basic mail 

{
    "to" : "hamzi1995-2014@hotmail.com",
    "Subject" : "Test mail",
    "text" : "Your Current Balance is :- 5000000$"
}
