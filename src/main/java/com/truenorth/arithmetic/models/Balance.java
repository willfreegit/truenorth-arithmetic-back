package com.truenorth.arithmetic.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Entity Balance
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Data
@Entity
@Table(name = "user_balance")
public class Balance {
    @Id
    private Long user_id;
    private BigDecimal balance;
}
