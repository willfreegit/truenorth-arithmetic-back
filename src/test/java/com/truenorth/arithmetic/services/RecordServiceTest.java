package com.truenorth.arithmetic.services;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.repository.RecordRepository;
import com.truenorth.arithmetic.services.imp.RecordServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test record service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
public class RecordServiceTest {
    @InjectMocks
    private RecordServiceImp recordServiceImp;

    @Mock
    private RecordRepository recordRepository;

    @Test
    public void saveRecordWithSuccess() {
        Record record = Record
                .builder()
                .userId(1L)
                .amount(new BigDecimal(0.1))
                .userBalance(new BigDecimal(10))
                .operationId(1L)
                .dateOperation(Date.valueOf(LocalDate.now()))
                .build();
        Mockito.when(recordRepository.save(record)).thenReturn(record);
        recordServiceImp.saveRecord(record);
        ArgumentCaptor<Record> bagCaptor = ArgumentCaptor.forClass(Record.class);
        Mockito.verify(recordRepository).save(bagCaptor.capture());
        assertEquals(record.getOperationId(), bagCaptor.getValue().getOperationId());
    }

    @Test
    public void getAll() {
        Record record1 = Record
                .builder()
                .userId(1L)
                .amount(new BigDecimal(0.1))
                .userBalance(new BigDecimal(10))
                .operationId(1L)
                .dateOperation(Date.valueOf(LocalDate.now()))
                .build();
        Record record2 = Record
                .builder()
                .userId(1L)
                .amount(new BigDecimal(0.2))
                .userBalance(new BigDecimal(20))
                .operationId(2L)
                .dateOperation(Date.valueOf(LocalDate.now()))
                .build();
        List<Record> list = Arrays.asList(record1, record2);
        Mockito.when(recordRepository.findAll()).thenReturn(list);
        List<Record> listQuery = recordServiceImp.getAll();
        Mockito.verify(recordRepository).findAll();
        assertNotNull(listQuery);
    }

}
