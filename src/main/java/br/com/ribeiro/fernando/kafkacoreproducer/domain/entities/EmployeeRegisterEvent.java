package br.com.ribeiro.fernando.kafkacoreproducer.domain.entities;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document("employee-register-events")
public class EmployeeRegisterEvent {
	
	@Id
	private String id;
	private String issuer;
	private Employee employee;
	private boolean success;
	private Date createdAt = new Date();
	
	public EmployeeRegisterEvent() {}

	public EmployeeRegisterEvent(@NonNull String issuer, @NonNull Employee employee, boolean success) {
		this.issuer = issuer;
		this.employee = employee;
		this.success = success;
	}
	
	public String getId() {
		return id;
	}

	public String getIssuer() {
		return issuer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Employee getEmployee() {
		return employee;
	}

	public boolean isSuccess() {
		return success;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, employee, id, issuer, success);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRegisterEvent other = (EmployeeRegisterEvent) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(employee, other.employee)
				&& Objects.equals(id, other.id) && Objects.equals(issuer, other.issuer) && success == other.success;
	}

}
