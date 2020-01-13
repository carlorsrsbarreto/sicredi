package org.sicredi.api.report;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientMQReportApi {

 private String QUEUE = "report";	
 private final RabbitTemplate rabbitTemplate;

  public ClientMQReportApi(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }
	
  public void send(String mensagem) {
    rabbitTemplate.convertAndSend(QUEUE, mensagem);
  }
  
}
