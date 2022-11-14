package br.com.coachme.controllers;

import javax.validation.Valid;
import br.com.coachme.config.RabbitMQConfig;
import br.com.coachme.dtos.EmailDto;
import br.com.coachme.models.EmailModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private RabbitTemplate template;

    @PostMapping("send-email")
    public ResponseEntity<String> sendEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);

        template.convertAndSend(RabbitMQConfig.queue, emailModel);
        return new ResponseEntity<>("E-mail send!", HttpStatus.CREATED);
    }
}
