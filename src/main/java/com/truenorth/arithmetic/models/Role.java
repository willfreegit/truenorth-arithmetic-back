package com.truenorth.arithmetic.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity Role
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private RoleEnum name;

}