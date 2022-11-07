package br.com.coachme.services;

import java.net.Authenticator;
import java.time.LocalDateTime;
import br.com.coachme.models.EmailModel;
import br.com.coachme.models.StatusEmail;
import br.com.coachme.repositories.EmailRepository;
import com.sun.mail.smtp.SMTPSaslAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender mailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSentDate(LocalDateTime.now());
        emailModel.setEmailFrom("lolcoachofficial@gmail.com");

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            mailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            System.out.println(e.getCause());
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(emailModel);
        }

    }
}
