package org.ticketbooking.core.dao.address.state;

import org.ticketbooking.core.domain.user.StateImpl;

public interface StateDao {
	void createState(StateImpl state);
	StateImpl fetchState(Long id);
	StateImpl fetchStateByName(String name);
}
