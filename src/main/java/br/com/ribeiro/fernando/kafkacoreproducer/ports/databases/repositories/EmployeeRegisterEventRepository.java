package br.com.ribeiro.fernando.kafkacoreproducer.ports.databases.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ribeiro.fernando.kafkacoreproducer.domain.entities.EmployeeRegisterEvent;

@Repository
public interface EmployeeRegisterEventRepository extends MongoRepository<EmployeeRegisterEvent, String> {

}
