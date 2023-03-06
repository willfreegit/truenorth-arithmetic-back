package com.truenorth.arithmetic.services.imp;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.repository.RecordRepository;
import com.truenorth.arithmetic.services.RecordService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements record service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Service
@Log4j2
public class RecordServiceImp implements RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public List<Record> getAll() {
        return recordRepository.findAll();
    }

    @Override
    public boolean saveRecord(Record record) {
        try{
            recordRepository.save(record);
            return true;
        } catch (Exception ex){
            log.error("Error SaveRecord: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Page<Record> getRecordsByUser(Long userId, Pageable pageable) {
        System.out.println("FIND USER.... " + userId);
        System.out.println(pageable);
        return recordRepository.findByUserId(userId, pageable);
    }


}
