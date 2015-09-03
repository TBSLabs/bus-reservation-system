package org.ticketbooking.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.ticketbooking.core.domain.common.audit.Auditable;
import org.ticketbooking.core.domain.common.listener.AuditableListener;

@Entity
@EntityListeners(value=AuditableListener.class)
@Table(name="TBS_CUSTOMER")
@NamedQueries(value={
		@NamedQuery(name="CustomerImpl.fetchByUsername",query="from CustomerImpl c where c.username=:username")
})
public class CustomerImpl implements Customer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Embedded
	protected Auditable auditable = new Auditable();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TBS_CUSTOMER_ID")
	private Long id;
	
	@Column(name="TBS_CUSTOMER_USERNAME",unique=true)
	private String username;
	
	@Column(name="TBS_CUSTOMER_PASSWORD")
	private String password;
	
	@Column(name="TBS_CUSTOMER_FIRSTNAME")
	private String firstName;
	
	@Column(name="TBS_CUSTOMER_LASTNAME")
	private String lastName;
	
	@Column(name="TBS_CUSTOMER_MIDDLE_NAME")
	private String middleName;
	
	@Column(name="TBS_CUSTOMER_EMAIL")
	private String email;
	
	@Column(name="TBS_CUSTOMER_PHONE")
	private String phone;
	
	@Column(name="TBS_CUSTOMER_ACTIVE")
	private boolean isActive;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Auditable getAudit() {
		return auditable;
	}

	public void setAudit(Auditable audit) {
		this.auditable = audit;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "CustomerImpl [audit=" + auditable + ", id=" + id + ", username="
				+ username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", email=" + email + ", phone=" + phone
				+ ", isActive=" + isActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditable == null) ? 0 : auditable.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerImpl other = (CustomerImpl) obj;
		if (auditable == null) {
			if (other.auditable != null)
				return false;
		} else if (!auditable.equals(other.auditable))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	
		
}
