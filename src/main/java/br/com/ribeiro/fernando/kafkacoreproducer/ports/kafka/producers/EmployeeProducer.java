package br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ribeiro.fernando.kafkacoreproducer.domain.entities.Employee;
import br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.topics.KafkaTopics;

@Component
public class EmployeeProducer {

	private KafkaTemplate<String, String> kafkaTemplate;
	private ObjectMapper objectMapper;

	@Autowired
	public EmployeeProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}
	
	public void sendMessage(Employee employee) throws JsonProcessingException {
		
		String json = objectMapper.writeValueAsString(employee);
		
		kafkaTemplate.send(KafkaTopics.employee(), employee.getEmail(), json);
		
	}
	
}
