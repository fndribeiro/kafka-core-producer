package br.com.ribeiro.fernando.kafkacoreproducer.application.services;

import org.springframework.stereotype.Service;

import br.com.ribeiro.fernando.kafkacoreproducer.domain.entities.EmployeeRegisterEvent;

@Service
public interface EmployeeRegisterEventService {

	public EmployeeRegisterEvent save(EmployeeRegisterEvent employeeRegisterEvent);
	
}
