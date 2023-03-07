package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.models.request.OperationRequest;
import com.truenorth.arithmetic.services.BalanceService;
import com.truenorth.arithmetic.services.OperationService;
import com.truenorth.arithmetic.services.RecordService;
import com.truenorth.arithmetic.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test operation controller
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@WithMockUser
@RunWith(SpringRunner.class)
@WebMvcTest(OperationController.class)
public class OperationControllerTest {

    private final String success = "200";

    @MockBean
    private OperationController operationController;

    @MockBean
    private OperationService operationService;

    @Mock
    private BalanceService balanceService;

    @Mock
    private RecordService recordService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMathOperationsBasicCallReturnStateOk() throws Exception {
        Long userId = 1L;

        BigDecimal balance = new BigDecimal(1);
        BigDecimal cost = new BigDecimal(0.1);
        OperationRequest operationRequest = OperationRequest.builder()
                .number1(1.0)
                .number2(2.0)
                .userId(userId)
                .operationId(1L)
                .type("NUMBER")
                .build();
        Record record = Record
                .builder()
                .operationId(operationRequest.getOperationId())
                .userId(operationRequest.getUserId())
                .amount(cost)
                .userBalance(balance)
                .operationResponse(success)
                .dateOperation(Date.valueOf(LocalDate.now()))
                .build();
        when(this.balanceService.updateBalanceByUser(userId, cost)).thenReturn(true);
        when(this.recordService.saveRecord(record)).thenReturn(true);

        mockMvc.perform(post("/truenorth/api/v1/operations/mathOperations")
                        .with(csrf())
                        .contextPath("/truenorth")
                        .content(Util.objectToJSONString(operationRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testMathOperationsBadParametersControlReturnOk() throws Exception {
        Long userId = 1L;

        BigDecimal balance = new BigDecimal(1);
        BigDecimal cost = new BigDecimal(0.1);
        OperationRequest operationRequest = OperationRequest.builder()
                .number1(1.0)
                .build();
        Record record = Record
                .builder()
                .operationId(operationRequest.getOperationId())
                .userId(operationRequest.getUserId())
                .amount(cost)
                .userBalance(balance)
                .operationResponse(success)
                .dateOperation(Date.valueOf(LocalDate.now()))
                .build();
        when(this.balanceService.updateBalanceByUser(userId, cost)).thenReturn(true);
        when(this.recordService.saveRecord(record)).thenReturn(true);

        mockMvc.perform(post("/truenorth/api/v1/operations/mathOperations")
                        .with(csrf())
                        .contextPath("/truenorth")
                        .content(Util.objectToJSONString(operationRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testMathOperationsBadDatabaseLocksOk() throws Exception {
        Long userId = 1L;

        BigDecimal balance = new BigDecimal(1);
        BigDecimal cost = new BigDecimal(0.1);
        OperationRequest operationRequest = OperationRequest.builder()
                .number1(1.0)
                .number2(2.0)
                .userId(userId)
                .operationId(4L)
                .type("NUMBER")
                .build();
        Record record = Record
                .builder()
                .operationId(operationRequest.getOperationId())
                .userId(operationRequest.getUserId())
                .amount(cost)
                .userBalance(balance)
                .operationResponse(success)
                .dateOperation(Date.valueOf(LocalDate.now()))
                .build();
        when(this.balanceService.updateBalanceByUser(userId, cost)).thenReturn(false);
        when(this.recordService.saveRecord(record)).thenReturn(false);

        mockMvc.perform(post("/truenorth/api/v1/operations/mathOperations")
                        .with(csrf())
                        .contextPath("/truenorth")
                        .content(Util.objectToJSONString(operationRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testMathOperationsDivisionZeroOk() throws Exception {
        Long userId = 1L;
        BigDecimal balance = new BigDecimal(1);
        BigDecimal cost = new BigDecimal(0.1);
        OperationRequest operationRequest = OperationRequest.builder()
                .number1(1.0)
                .number2(2.0)
                .userId(userId)
                .operationId(4L)
                .type("NUMBER")
                .build();
        Record record = Record
                .builder()
                .operationId(operationRequest.getOperationId())
                .userId(operationRequest.getUserId())
                .amount(cost)
                .userBalance(balance)
                .operationResponse(success)
                .dateOperation(Date.valueOf(LocalDate.now()))
                .build();
        when(this.balanceService.updateBalanceByUser(userId, cost)).thenReturn(false);
        when(this.recordService.saveRecord(record)).thenReturn(false);

        mockMvc.perform(post("/truenorth/api/v1/operations/mathOperations")
                        .with(csrf())
                        .contextPath("/truenorth")
                        .content(Util.objectToJSONString(operationRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
