package br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ribeiro.fernando.kafkacoreproducer.application.services.EmployeeRegisterEventService;
import br.com.ribeiro.fernando.kafkacoreproducer.domain.entities.Employee;
import br.com.ribeiro.fernando.kafkacoreproducer.domain.entities.EmployeeRegisterEvent;
import br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.topics.KafkaTopics;

@Component
public class EmployeeProducer {

	private final Logger logger = LoggerFactory.getLogger(EmployeeProducer.class);
	
	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper objectMapper;
	private EmployeeRegisterEventService service;

	@Autowired
	public EmployeeProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper, EmployeeRegisterEventService service) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
		this.service = service;
	}
	
	public void sendMessage(Employee employee, String userAgent) throws JsonProcessingException {
		
		String json = objectMapper.writeValueAsString(employee);
		
		kafkaTemplate.send(KafkaTopics.employee(), employee.getEmail(), json)
			.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

				@Override
				public void onSuccess(SendResult<String, String> result) {
					
					logger.info("Employee {} published successfully", result);
					
					var registerEvent = new EmployeeRegisterEvent(userAgent, employee, true);
					
					service.save(registerEvent);
					
				}

				@Override
				public void onFailure(Throwable ex) {
					
					logger.warn("Failed to publish employee {}. Reason: {}",
							employee,
							ex.getMessage());
					
					var registerEvent = new EmployeeRegisterEvent(userAgent, employee, false);
					
					service.save(registerEvent);
					
				}
				
			});
		
	}
	
}
