package com.truenorth.arithmetic.repository;

import com.truenorth.arithmetic.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
