package com.truenorth.arithmetic.services.imp;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.repository.RecordRepository;
import com.truenorth.arithmetic.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implements record service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Service
public class RecordServiceImp implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public boolean saveRecord(Record record) {
        try{
            recordRepository.save(record);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    public Page<Record> getRecordsByUser(Long userId, Pageable pageable) {
        return recordRepository.findByUserId(userId, pageable);
    }
}
