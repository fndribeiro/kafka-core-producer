package br.com.ribeiro.fernando.kafkacoreproducer.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ribeiro.fernando.kafkacoreproducer.domain.entities.EmployeeRegisterEvent;
import br.com.ribeiro.fernando.kafkacoreproducer.ports.databases.repositories.EmployeeRegisterEventRepository;

@Service
public class EmployeeRegisterEventServiceImpl implements EmployeeRegisterEventService {
	
	private EmployeeRegisterEventRepository repository;
	
	@Autowired
	public EmployeeRegisterEventServiceImpl(EmployeeRegisterEventRepository repository) {
		this.repository = repository;
	}

	@Override
	public EmployeeRegisterEvent save(EmployeeRegisterEvent employeeRegisterEvent) {
		return repository.save(employeeRegisterEvent);
	}
	
}
