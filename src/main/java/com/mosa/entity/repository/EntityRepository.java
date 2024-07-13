package com.mosa.entity.repository;

import com.mosa.entity.model.EntityT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository<EntityT, Long> {
}