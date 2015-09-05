package org.ticketbooking.core.dao.address.state;

import org.ticketbooking.core.domain.user.State;

public interface StateDao {
	void createState(State state);
	State fetchState(Long id);
	State fetchStateByName(String name);
}
