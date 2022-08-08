package br.com.ribeiro.fernando.kafkacoreproducer.domain.entities;

import java.util.Objects;

import com.mongodb.lang.NonNull;

import br.com.ribeiro.fernando.kafkacoreproducer.domain.valueobjects.EmployeeType;

public class Employee {

	private String name;
	private String email;
	private EmployeeType type;
	
	public Employee(@NonNull String name, @NonNull String email, @NonNull EmployeeType type) {
		this.name = name;
		this.email = email;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public EmployeeType getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(name, other.name) && type == other.type;
	}

}
