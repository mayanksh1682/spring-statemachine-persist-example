package com.mosa.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

@Entity
@Table(name = "entity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityT {
  @Id
  @Column(name = "id", nullable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "state")
  @Enumerated(value = EnumType.STRING)
  private EntityStates state;
}
