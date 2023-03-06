package com.truenorth.arithmetic.services;

import com.truenorth.arithmetic.models.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Record service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
public interface RecordService {
    public boolean saveRecord(Record record);
    public Page<Record> getRecordsByUser(Long userId, Pageable pageable);
}
