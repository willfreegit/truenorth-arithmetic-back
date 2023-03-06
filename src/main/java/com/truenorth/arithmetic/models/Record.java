package com.truenorth.arithmetic.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Entity Record
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private Long operation_id;
    @NotBlank
    private Long user_id;
    private double amount;
    private BigDecimal user_balance;
    private String operation_response;
    private Date date;
}
