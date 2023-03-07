package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.models.Record;
import com.truenorth.arithmetic.models.request.RecordRequest;
import com.truenorth.arithmetic.services.RecordService;
import com.truenorth.arithmetic.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test record controller
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@WithMockUser
@RunWith(SpringRunner.class)
@WebMvcTest(RecordController.class)
public class RecordControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecordService recordService;

    @Test
    public void testRecordControllerWhenTheRequestIsOkThenReturnOk() throws Exception {
        Long userId = 1L;
        Pageable paging = PageRequest.of(0, 10);
        RecordRequest recordRequest = RecordRequest
                .builder()
                .page(0)
                .size(1)
                .userId(userId).build();
        List<Record> list = Arrays.asList(Record.builder().userId(userId).build());
        Page<Record> pages = new PageImpl<>(list);
        when(this.recordService.getRecordsByUser(userId, null, paging)).thenReturn(pages);
        mockMvc.perform(get("/truenorth/api/v1/records/getRecordsByUser").contextPath("/truenorth")
                        .content(Util.objectToJSONString(recordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testRecordControllerWithEmptySizeOrEmptyPageThenReturnBadRequest() throws Exception {
        Long userId = 1L;
        Pageable paging = PageRequest.of(0, 10);
        RecordRequest recordRequest = RecordRequest
                .builder()
                .userId(userId).build();
        List<Record> list = Arrays.asList(Record.builder().userId(userId).build());
        Page<Record> pages = new PageImpl<>(list);
        when(this.recordService.getRecordsByUser(userId, null, paging)).thenReturn(pages);
        mockMvc.perform(get("/truenorth/api/v1/records/getRecordsByUser").contextPath("/truenorth")
                        .content(Util.objectToJSONString(recordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testRecordControllerWhenThePageOrSizeIsNotAValidNumberThenReturnBadRequest() throws Exception {
        Long userId = 1L;
        Pageable paging = PageRequest.of(0, 10);
        RecordRequest recordRequest = RecordRequest
                .builder()
                .page(0)
                .size(-1)
                .userId(userId).build();
        List<Record> list = Arrays.asList(Record.builder().userId(userId).build());
        Page<Record> pages = new PageImpl<>(list);
        when(this.recordService.getRecordsByUser(userId, null, paging)).thenReturn(pages);
        mockMvc.perform(get("/truenorth/api/v1/records/getRecordsByUser").contextPath("/truenorth")
                        .content(Util.objectToJSONString(recordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testRecordControllerWhenTheUserIsEmptyhenReturnBadRequest() throws Exception {
        Long userId = 1L;
        Pageable paging = PageRequest.of(0, 10);
        RecordRequest recordRequest = RecordRequest
                .builder()
                .page(0)
                .size(1).build();
        List<Record> list = Arrays.asList(Record.builder().userId(userId).build());
        Page<Record> pages = new PageImpl<>(list);
        when(this.recordService.getRecordsByUser(userId, null, paging)).thenReturn(pages);
        mockMvc.perform(get("/truenorth/api/v1/records/getRecordsByUser").contextPath("/truenorth")
                        .content(Util.objectToJSONString(recordRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
