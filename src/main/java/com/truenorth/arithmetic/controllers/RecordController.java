package com.truenorth.arithmetic.controllers;

import com.truenorth.arithmetic.models.Record;
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
    public ResponseEntity<Map<String, Object>> getRecordsByUser(@RequestBody RecordRequest recordRequest) {
        if(recordRequest.getPage() == null || recordRequest.getSize() == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            if(recordRequest.getPage() < 0 || recordRequest.getSize() < 0){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }
        Pageable paging = PageRequest.of(recordRequest.getPage(), recordRequest.getSize());
        Page<Record> pages = recordService.getRecordsByUser(recordRequest.getUserId(), recordRequest.getFilters(), paging);
        Map<String, Object> response = new HashMap<>();
        if(pages != null){
            List<Record> records = pages.getContent();
            response.put("records", records);
            response.put("currentPage", pages.getNumber());
            response.put("totalItems", pages.getTotalElements());
            response.put("totalPages", pages.getTotalPages());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
