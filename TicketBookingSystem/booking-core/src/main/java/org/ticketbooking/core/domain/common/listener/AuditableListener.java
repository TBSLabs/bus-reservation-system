package org.ticketbooking.core.domain.common.listener;

import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.ticketbooking.core.domain.common.audit.Auditable;

public class AuditableListener {

	@PrePersist
	public void setAuditableFieldforCreate(Object entity) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		if (entity.getClass().isAnnotationPresent(Entity.class)) {
			Field field = getSingleField(entity.getClass(), "auditable");
			field.setAccessible(true);
			if (field.isAnnotationPresent(Embedded.class)) {
				Object auditable = field.get(entity);
				if (auditable == null) {
					field.set(entity, new Auditable());
					auditable = field.get(entity);
				}
				Field temporalField = auditable.getClass().getDeclaredField("createdDate");
				Field agentField = auditable.getClass().getDeclaredField("lastUpdatedDate");
				setAuditValueTemporal(temporalField, auditable);
				setAuditValueTemporal(agentField, auditable);
			}
		}
	}
	
	@PreUpdate
	public void setAuditableFieldForUdate(Object entity) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException{
		if (entity.getClass().isAnnotationPresent(Entity.class)) {
			Field field = getSingleField(entity.getClass(), "auditable");
			field.setAccessible(true);
			if (field.isAnnotationPresent(Embedded.class)) {
				Object auditable = field.get(entity);
				if (auditable == null) {
					field.set(entity, new Auditable());
					auditable = field.get(entity);
				}
				Field agentField = auditable.getClass().getDeclaredField("lastUpdatedDate");
				setAuditValueTemporal(agentField, auditable);
			}
		}
	}
	

	private void setAuditValueTemporal(Field temporalField, Object auditable) throws IllegalArgumentException, IllegalAccessException {
		temporalField.setAccessible(true);
		temporalField.set(auditable, new Date());
	}

	private Field getSingleField(Class<?> clazz, String fieldName)
			throws IllegalStateException {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException nsf) {
			// Try superclass
			if (clazz.getSuperclass() != null) {
				return getSingleField(clazz.getSuperclass(), fieldName);
			}

			return null;
		}
	}
}
