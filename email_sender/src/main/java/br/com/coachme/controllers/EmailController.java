package br.com.coachme.controllers;

import javax.validation.Valid;
import br.com.coachme.dtos.EmailDto;
import br.com.coachme.models.EmailModel;
import br.com.coachme.services.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("send-email")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody @Valid EmailDto emailDto) {
            EmailModel emailModel = new EmailModel();
            BeanUtils.copyProperties(emailDto, emailModel);
            emailService.sendEmail(emailModel);
            return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}
