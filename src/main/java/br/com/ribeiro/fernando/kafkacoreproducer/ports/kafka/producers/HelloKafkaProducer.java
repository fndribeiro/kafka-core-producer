package br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.topics.KafkaTopics;

@Service
public class HelloKafkaProducer {
	
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public HelloKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String name) {
		kafkaTemplate.send(KafkaTopics.hello(), "Hello " + name + "!");
	}

}
