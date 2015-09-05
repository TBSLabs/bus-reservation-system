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
@Table(name="TBS_CUSTOMER_ADDRESS")
public class CustomerAddressImpl implements CustomerAddress{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5517676145261999176L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TBS_CUSTOMER_ADDRESS_ID")
	private Long id;
	
	@Column(name="TBS_CUSTOMER_ADDRESS_NAME")
	private String addressName;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=CustomerImpl.class)
	@JoinColumn(name="TBS_CUSTOMER_ID")
	private Customer customer;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=AddressImpl.class)
	@JoinColumn(name="TBS_ADDRESS_ID")
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
