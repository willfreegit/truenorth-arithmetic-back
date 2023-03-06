package com.truenorth.arithmetic.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Entity Operation
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private BigDecimal cost;
}
