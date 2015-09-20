package org.ticketbooking.core.dao.address.state;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.ticketbooking.common.utils.ApplicationObjectUtils;
import org.ticketbooking.core.domain.user.State;
import org.ticketbooking.core.domain.user.StateImpl;

@Repository("stateDao")
public class StateDaoImpl implements StateDao{

	@PersistenceContext
	EntityManager entityManager;
	
	public void createState(State state) {
		entityManager.persist(state);
	}

	public State fetchState(Long id) {
		return entityManager.find(StateImpl.class, id);
	}

	@SuppressWarnings("unchecked")
	public State fetchStateByName(String name) {
		Query query = entityManager.createNamedQuery("StateImpl.fetchByStateName");
		query.setParameter("name", name);
		List<State> states = query.getResultList();
		return ApplicationObjectUtils.isNull(states) || states.isEmpty() ? null : states.get(0);
	}

}
