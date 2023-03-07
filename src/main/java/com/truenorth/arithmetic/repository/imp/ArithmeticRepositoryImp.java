package com.truenorth.arithmetic.repository.imp;

import com.truenorth.arithmetic.functions.ArithmeticOperator;
import com.truenorth.arithmetic.repository.ArithmeticRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Class consume external resource
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@Repository
public class ArithmeticRepositoryImp implements ArithmeticRepository {
    @Override
    public double mathOperations(ArithmeticOperator operation, Double a, Double b) {
        return operation.apply(a, b);
    }

    @Override
    public String random_string(int length) {
        RestTemplate template = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("len", String.valueOf(length));
        ResponseEntity<String> response =
                template.exchange("https://www.random.org/strings/?num=1&len={len}&digits=on&upperalpha=on&loweralpha=on&unique=on&format=plain&rnd=new",
                        HttpMethod.GET,
                        null,
                        String.class,
                        uriVariables);
        return response.getBody();
    }
}
