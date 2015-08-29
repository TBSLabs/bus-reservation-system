package org.ticketbooking.core.domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TBS_ADDRESS")
@NamedQueries(value={
		@NamedQuery(name="AddressImpl.fetchByCustomer",query="from AddressImpl a where a.customer.id=:id")
})
public class AddressImpl implements Serializable,Address{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TBS_ADDRESS_ID")
	private Long id;
	
	@Column(name="TBS_ADDRESS_STREET1")
	private String street1;
	
	@Column(name="TBS_ADDRESS_STREET2")
	private String stree2;
	
	@Column(name="TBS_ADDRESS_PIN")
	private Long pin;
	
	@Column(name="TBS_ADDRESS_CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="TBS_ADDRESS_UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@ManyToOne
	@JoinColumn(name="TBS_STATE_ID",nullable=false)
	private StateImpl state;
	
	@ManyToOne
	@JoinColumn(name="TBS_CUSTOMER_ID")
	private CustomerImpl customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStree2() {
		return stree2;
	}

	public void setStree2(String stree2) {
		this.stree2 = stree2;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public State getState() {
		return state;
	}

	public void setState(StateImpl state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerImpl customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AddressImpl [id=" + id + ", street1=" + street1 + ", stree2="
				+ stree2 + ", pin=" + pin + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", state=" + state
				+ ", customer=" + customer + "]";
	}
	
	
}
