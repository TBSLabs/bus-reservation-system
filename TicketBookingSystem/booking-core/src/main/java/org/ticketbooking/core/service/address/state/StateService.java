package org.ticketbooking.core.service.address.state;

import org.ticketbooking.core.domain.user.StateImpl;

public interface StateService {
	void createState(StateImpl state);
	StateImpl fetchState(Long id);
	StateImpl fetchStateByName(String name);
}
