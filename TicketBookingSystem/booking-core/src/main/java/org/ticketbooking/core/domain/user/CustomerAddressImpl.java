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
	private CustomerImpl customer;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=AddressImpl.class)
	@JoinColumn(name="TBS_ADDRESS_ID")
	private AddressImpl address;

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

	public CustomerImpl getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerImpl customer) {
		this.customer = customer;
	}

	public AddressImpl getAddress() {
		return address;
	}

	public void setAddress(AddressImpl address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerAddressImpl [id=" + id + ", addressName=" + addressName
				+ ", customer=" + customer + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((addressName == null) ? 0 : addressName.hashCode());
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CustomerAddressImpl other = (CustomerAddressImpl) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (addressName == null) {
			if (other.addressName != null)
				return false;
		} else if (!addressName.equals(other.addressName))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
