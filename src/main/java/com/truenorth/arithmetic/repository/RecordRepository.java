package com.truenorth.arithmetic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.truenorth.arithmetic.models.Record;

import java.sql.Date;


public interface RecordRepository extends JpaRepository<Record, Long> {
    Page<Record> findByUserId(Long userId, Pageable pageable);
    Page<Record> findByUserIdAndOperationIdLike(Long userId, Long operationId, Pageable pageable);
    Page<Record> findByUserIdAndOperationResponseLike(Long userId, String operationResponse, Pageable pageable);
    Page<Record> findByUserIdAndDateOperationBetween(Long userId, Date fini, Date fend, Pageable pageable);
    Page<Record> findByUserIdAndOperationIdLikeAndOperationResponseLike(Long userId, Long operationId, String operationResponse, Pageable pageable);
    Page<Record> findByUserIdAndOperationIdLikeAndDateOperationBetween(Long userId, Long operationId, Date fini, Date fend, Pageable pageable);
    Page<Record> findByUserIdAndOperationResponseLikeAndDateOperationBetween(Long userId, String operationResponse, Date fini, Date fend, Pageable pageable);
    Page<Record> findByUserIdAndOperationIdLikeAndOperationResponseLikeAndDateOperationBetween(Long userId, Long operationId, String operationResponse, Date fini, Date fend, Pageable pageable);
}
