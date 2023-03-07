package com.truenorth.arithmetic.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "records")
@SQLDelete(sql="UPDATE records SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "operation_id")
    private Long operationId;
    @NotNull
    @Column(name = "user_id")
    private Long userId;
    private BigDecimal amount;
    @Column(name = "user_balance")
    private BigDecimal userBalance;
    @Column(name = "operation_response")
    private String operationResponse;
    @Column(name = "date_operation")
    private Date dateOperation;
    private Boolean deleted = Boolean.FALSE;
}
