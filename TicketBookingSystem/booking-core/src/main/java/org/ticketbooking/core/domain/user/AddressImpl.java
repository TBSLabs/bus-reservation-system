package org.ticketbooking.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.ticketbooking.core.domain.common.audit.Auditable;
import org.ticketbooking.core.domain.common.listener.AuditableListener;

@Entity
@EntityListeners(value=AuditableListener.class)
@Table(name="TBS_ADDRESS")
public class AddressImpl implements Address{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Embedded
	protected Auditable auditable = new Auditable();
	
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
	
	@Column(name="TBS_DEFAULT_ADDRESS")
	private boolean isDefaultAddress;
	
	@Column(name="TBS_ACTIVE_ADDRESS")
	private boolean isActiveAddress;
	
	@ManyToOne(targetEntity=StateImpl.class)
	@JoinColumn(name="TBS_STATE_ID",nullable=false)
	private State state;
	

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	
	public Auditable getAudit() {
		return auditable;
	}

	public void setAudit(Auditable audit) {
		this.auditable = audit;
	}

	public boolean isDefaultAddress() {
		return isDefaultAddress;
	}

	public void setDefaultAddress(boolean isDefaultAddress) {
		this.isDefaultAddress = isDefaultAddress;
	}

	public boolean isActiveAddress() {
		return isActiveAddress;
	}

	public void setActiveAddress(boolean isActiveAddress) {
		this.isActiveAddress = isActiveAddress;
	}

	@Override
	public String toString() {
		return "AddressImpl [audit=" + auditable + ", id=" + id + ", street1="
				+ street1 + ", stree2=" + stree2 + ", pin=" + pin
				+ ", isDefaultAddress=" + isDefaultAddress
				+ ", isActiveAddress=" + isActiveAddress + ", state=" + state
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditable == null) ? 0 : auditable.hashCode());
		
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActiveAddress ? 1231 : 1237);
		result = prime * result + (isDefaultAddress ? 1231 : 1237);
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((stree2 == null) ? 0 : stree2.hashCode());
		result = prime * result + ((street1 == null) ? 0 : street1.hashCode());
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
		AddressImpl other = (AddressImpl) obj;
		if (auditable == null) {
			if (other.auditable != null)
				return false;
		} else if (!auditable.equals(other.auditable))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActiveAddress != other.isActiveAddress)
			return false;
		if (isDefaultAddress != other.isDefaultAddress)
			return false;
		if (pin == null) {
			if (other.pin != null)
				return false;
		} else if (!pin.equals(other.pin))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stree2 == null) {
			if (other.stree2 != null)
				return false;
		} else if (!stree2.equals(other.stree2))
			return false;
		if (street1 == null) {
			if (other.street1 != null)
				return false;
		} else if (!street1.equals(other.street1))
			return false;
		return true;
	}
	
	
	
}
