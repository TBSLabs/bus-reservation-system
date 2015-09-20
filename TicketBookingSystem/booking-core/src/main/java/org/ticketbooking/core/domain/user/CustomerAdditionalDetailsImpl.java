package org.ticketbooking.core.domain.user;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="TRS_CUSTOMER_ADDITIONAL")
public class CustomerAdditionalDetailsImpl implements CustomerAdditionalDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRS_CUSTOMER_ADDITIONAL_ID")
	private Long id;
	
	@ManyToOne(targetEntity=CustomerImpl.class,cascade=CascadeType.ALL)
	@JoinColumn(name="TBS_CUSTOMER_ID")
	private Customer customer;
	
	@Column(name="TRS_CUSTOMER_ADDITIONAL_NAME")
	private String name;
	
	@Column(name="TRS_CUSTOMER_ADDITIONAL_VALUE")
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
