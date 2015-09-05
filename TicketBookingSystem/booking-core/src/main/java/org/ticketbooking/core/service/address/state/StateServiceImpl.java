package org.ticketbooking.core.service.address.state;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ticketbooking.core.dao.address.state.StateDao;
import org.ticketbooking.core.domain.user.State;

@Service("stateService")
public class StateServiceImpl implements StateService{
	
	@Resource(name="stateDao")
	StateDao dao;
	
	@Transactional("tbsTransaction")
	public void createState(State state) {
		dao.createState(state);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public State fetchState(Long id) {
		return dao.fetchState(id);
	}

	@Transactional(value="tbsTransaction",readOnly=true)
	public State fetchStateByName(String name) {
		return dao.fetchStateByName(name);
	}

}
