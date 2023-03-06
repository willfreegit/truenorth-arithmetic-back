package com.truenorth.arithmetic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.truenorth.arithmetic.models.Record;


public interface RecordRepository extends JpaRepository<Record, Long> {
    Page<Record> findByUserId(Long userId, Pageable pageable);
}
