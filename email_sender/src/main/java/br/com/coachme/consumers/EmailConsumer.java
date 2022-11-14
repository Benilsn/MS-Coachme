package br.com.coachme.consumers;

import br.com.coachme.config.RabbitMQConfig;
import br.com.coachme.models.EmailModel;
import br.com.coachme.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = RabbitMQConfig.queue)
    public void listen(EmailModel emailModel) {

        emailService.sendEmail(emailModel);
        System.out.println("Email Status:" + emailModel.getStatusEmail().toString());
    }

}
