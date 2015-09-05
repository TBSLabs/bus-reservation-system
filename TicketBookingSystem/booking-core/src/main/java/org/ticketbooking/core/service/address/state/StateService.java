package org.ticketbooking.core.service.address.state;

import org.ticketbooking.core.domain.user.State;

public interface StateService {
	void createState(State state);
	State fetchState(Long id);
	State fetchStateByName(String name);
}
