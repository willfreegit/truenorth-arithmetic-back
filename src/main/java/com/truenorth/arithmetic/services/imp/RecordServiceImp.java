package com.truenorth.arithmetic.services.imp;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.models.request.RecordRequest;
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
    public Page<Record> getRecordsByUser(Long userId, RecordRequest.Filters filters, Pageable pageable) {
        if(filters != null){
            switch (filters.getFiltersId()){
                case "1": return recordRepository.findByUserIdAndOperationIdLike(
                        userId, filters.getOperationId(), pageable);
                case "2": return recordRepository.findByUserIdAndOperationResponseLike(
                        userId, filters.getOperationResponse(), pageable);
                case "3": return recordRepository.findByUserIdAndDateOperationBetween(
                        userId, filters.getFini(), filters.getFend(), pageable);
                case "12": return recordRepository.findByUserIdAndOperationIdLikeAndOperationResponseLike(
                        userId, filters.getOperationId(), filters.getOperationResponse(), pageable);
                case "13": return recordRepository.findByUserIdAndOperationIdLikeAndDateOperationBetween(
                        userId, filters.getOperationId(), filters.getFini(), filters.getFend(), pageable);
                case "23": return recordRepository.findByUserIdAndOperationResponseLikeAndDateOperationBetween(
                        userId, filters.getOperationResponse(), filters.getFini(), filters.getFend(), pageable);
                case "123": return recordRepository.findByUserIdAndOperationIdLikeAndOperationResponseLikeAndDateOperationBetween(
                        userId, filters.getOperationId(), filters.getOperationResponse(), filters.getFini(), filters.getFend(), pageable);
                default: return recordRepository.findByUserId(userId, pageable);
            }
        }
        return recordRepository.findByUserId(userId, pageable);
    }


}
