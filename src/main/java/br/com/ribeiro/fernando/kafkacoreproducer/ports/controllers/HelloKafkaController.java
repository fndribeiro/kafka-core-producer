package br.com.ribeiro.fernando.kafkacoreproducer.ports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.producers.HelloKafkaProducer;

@RestController
@RequestMapping("/hello")
public class HelloKafkaController {
	
	private HelloKafkaProducer kafkaProducer;
	
	@Autowired
	public HelloKafkaController(HelloKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@PostMapping("/{name}")
	public void sendHelloMessage(@PathVariable(value = "name") String name) {
		kafkaProducer.sendMessage(name);
	}
	
}
