package com.example.demo.mail.service;

import java.nio.charset.StandardCharsets;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.example.demo.mail.model.Mail;

@Service
public class MailServiceImpl implements MailService
{
	@Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;


    public Mail sendMail(Mail mail) throws MessagingException 
    {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        helper.addAttachment("logo.png", new ClassPathResource("memorynotfound-logo.png"));

        Context context = new Context();
        context.setVariables(mail.getModel());
        String html = templateEngine.process("email-template", context);

        String[] strArray = { "How@gmail.com", "To@gmail.com", "Do@gmail.com", "In@gmail.com", "Java@gmail.com" };
        /**Address[] ia = new InternetAddress[strArray.length];
        int i = 0;
        for (String address : strArray) {
            ia[i] = new InternetAddress(address);
            i++;
        }
        message.addRecipients(RecipientType.TO, ia);**/
        
        helper.setTo(strArray);
        helper.setText(html, true);
        helper.setSubject(mail.getSubject());
        helper.setFrom(mail.getFrom());

        emailSender.send(message);
        
        templateEngine.clearTemplateCache();
        
        return mail;
    }

}
