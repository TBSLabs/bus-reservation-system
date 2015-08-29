package org.ticketbooking.core.dao.address.state;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.ticketbooking.core.domain.user.StateImpl;

@Repository("stateDao")
public class StateDaoImpl implements StateDao{

	@PersistenceContext
	EntityManager entityManager;
	
	public void createState(StateImpl state) {
		entityManager.persist(state);
	}

	public StateImpl fetchState(Long id) {
		return entityManager.find(StateImpl.class, id);
	}

	public StateImpl fetchStateByName(String name) {
		Query query = entityManager.createNamedQuery("StateImpl.fetchByStateName");
		query.setParameter("name", name);
		return (StateImpl) query.getSingleResult();
	}

}
