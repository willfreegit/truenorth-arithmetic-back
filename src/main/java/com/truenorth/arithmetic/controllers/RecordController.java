package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.models.request.RecordRequest;
import com.truenorth.arithmetic.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.truenorth.arithmetic.models.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class records controller
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/getRecordsByUser")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> getAllTutorials(@RequestBody RecordRequest recordRequest) {
        try {
            Pageable paging = PageRequest.of(recordRequest.getPage(), recordRequest.getSize());
            Page<Record> pages = recordService.getRecordsByUser(recordRequest.getUserId(), recordRequest.getFilters(), paging);
            List<Record> records = pages.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("records", records);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
