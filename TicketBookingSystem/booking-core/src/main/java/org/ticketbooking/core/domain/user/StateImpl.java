package org.ticketbooking.core.domain.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TBS_STATE")
@NamedQueries(value={
		@NamedQuery(name="StateImpl.fetchByStateName",query="from StateImpl s where s.name=:name")
})
public class StateImpl implements Serializable,State{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TBS_STATE")
	private Long id;
	
	@Column(name="TBS_STATE_NAME")
	private String name;
	
	@OneToOne(cascade=CascadeType.REFRESH,targetEntity=CountryImpl.class)
	@PrimaryKeyJoinColumn
	private Country country;
	
	@OneToMany(mappedBy="state",targetEntity=AddressImpl.class)
	private Set<Address> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "StateImpl [id=" + id + ", name=" + name + ", country="
				+ country + ", addresses=" + addresses + "]";
	}

	
}
