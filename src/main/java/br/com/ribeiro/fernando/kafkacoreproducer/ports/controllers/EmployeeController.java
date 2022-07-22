package br.com.ribeiro.fernando.kafkacoreproducer.ports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.ribeiro.fernando.kafkacoreproducer.domain.entities.Employee;
import br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.producers.EmployeeProducer;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeProducer employeeProducer;
	
	@Autowired
	public EmployeeController(EmployeeProducer employeeProducer) {
		this.employeeProducer = employeeProducer;
	}

	@PostMapping
	public void sendMessage(@RequestBody Employee employee) throws JsonProcessingException {
		employeeProducer.sendMessage(employee);
	}
	
}
