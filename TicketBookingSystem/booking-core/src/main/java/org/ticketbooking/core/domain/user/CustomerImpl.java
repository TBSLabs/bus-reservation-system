package org.ticketbooking.core.domain.user;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
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
	
	@Column(name="TBS_CUSTOMER_VARIFIED")
	private boolean isVarified;
	
	@OneToMany(targetEntity=CustomerAdditionalDetailsImpl.class,mappedBy="customer")
	@MapKey(name="name")
	@BatchSize(size=20)
	private Map<String,CustomerAdditionalDetails> customerAdditional = new HashMap<String, CustomerAdditionalDetails>();
	

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

	public boolean isVarified() {
		return isVarified;
	}

	public void setVarified(boolean isVarified) {
		this.isVarified = isVarified;
	}

	public Auditable getAuditable() {
		return auditable;
	}

	public void setAuditable(Auditable auditable) {
		this.auditable = auditable;
	}

	public Map<String, CustomerAdditionalDetails> getCustomerAdditional() {
		return customerAdditional;
	}

	public void setCustomerAdditional(
			Map<String, CustomerAdditionalDetails> customerAdditional) {
		this.customerAdditional = customerAdditional;
	}
	

}
