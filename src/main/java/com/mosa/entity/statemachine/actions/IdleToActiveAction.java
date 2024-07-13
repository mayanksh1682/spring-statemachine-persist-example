package com.mosa.entity.statemachine.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import com.mosa.entity.model.EntityT;
import com.mosa.entity.utils.EntityConstants;

@Component
public class IdleToActiveAction implements Action<String, String> {

  private final static Logger logger = LoggerFactory.getLogger(IdleToActiveAction.class);

  @Override
  public void execute(StateContext<String, String> context) {
    EntityT entity = (EntityT) context.getMessageHeader(EntityConstants.entityHeader);
    if (entity == null) {
      logger.debug("Action: Wrong transition?");
    } else {
      logger.debug("Action: changing the idle entity to active.. {}", entity);
    }
  }
}
