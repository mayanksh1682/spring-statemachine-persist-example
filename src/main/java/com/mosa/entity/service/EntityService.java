package com.mosa.entity.service;

import com.google.common.collect.Lists;
import com.mosa.entity.model.EntityT;
import com.mosa.entity.model.EntityEvents;
import com.mosa.entity.repository.EntityRepository;
import com.mosa.entity.utils.EntityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

	@Autowired
	private EntityRepository entityRepository;

	@Autowired
	private PersistStateMachineHandler persistStateMachineHandler;

	public List<EntityT> getEntities() {
		return Lists.newArrayList(entityRepository.findAll());
	}

	public EntityT getEntity(Long id) {
		return entityRepository.findById(id).orElse(null);
	}

	public EntityT createEntity(EntityT entity) {
		return entityRepository.save(entity);
	}

	@SuppressWarnings("deprecation")
	public Boolean updateState(Long id, EntityEvents event) {
		EntityT entity = entityRepository.findById(id).orElse(null);

		return persistStateMachineHandler.handleEventWithState(
				MessageBuilder.withPayload(event.name()).setHeader(EntityConstants.entityHeader, entity).build(),
				entity.getState().name());
	}
}
