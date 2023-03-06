package com.truenorth.arithmetic.repository;

import com.truenorth.arithmetic.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
