package com.mosa.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mosa.entity.model.EntityEvents;
import com.mosa.entity.model.EntityT;
import com.mosa.entity.service.EntityService;

@RestController
@RequestMapping("/entity")
public class EntityController {

  @Autowired
  private EntityService entityService;

  @GetMapping("/")
  public List<EntityT> getEntities() {
    return entityService.getEntities();
  }

  @GetMapping("/{id}")
  public EntityT getEntity(@PathVariable("id") Long id) {
    return entityService.getEntity(id);
  }

  @PostMapping("/create")
  public EntityT createEntity(@RequestBody EntityT entity) {
    return entityService.createEntity(entity);
  }

  @GetMapping("/{id}/update/{event}")
  public Boolean sendEvent(@PathVariable("id") Long id, @PathVariable("event") EntityEvents event) {
    return entityService.updateState(id, event);
  }
}
