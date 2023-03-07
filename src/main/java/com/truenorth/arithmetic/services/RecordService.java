package com.truenorth.arithmetic.services;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.models.request.RecordRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Record service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
public interface RecordService {
    List<Record> getAll();
    void remove(Long id);
    boolean saveRecord(Record record);
    Page<Record> getRecordsByUser(Long userId, RecordRequest.Filters filters, Pageable pageable);
}
