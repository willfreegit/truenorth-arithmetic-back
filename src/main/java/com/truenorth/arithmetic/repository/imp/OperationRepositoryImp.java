package com.truenorth.arithmetic.repository.imp;

import com.truenorth.arithmetic.repository.OperationRepository;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class OperationRepositoryImp implements OperationRepository {
    @Override
    public double addition(double number1, double number2) {
        return number1 + number2;
    }

    @Override
    public double subtraction(double number1, double number2) {
        return number1 - number2;
    }

    @Override
    public double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    @Override
    public double division(double number1, double number2) {
        return number1 / number2;
    }

    @Override
    public double square_root(double number) {
        return Math.sqrt(number);
    }

    @Override
    public String random_string(int number, int length) {
        RestTemplate template = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("num", String.valueOf(number));
        uriVariables.put("len", String.valueOf(length));
        ResponseEntity<String> response =
                template.exchange("https://www.random.org/strings/?num={num}&len={len}&digits=on&upperalpha=on&loweralpha=on&unique=on&format=plain&rnd=new",
                        HttpMethod.GET,
                        null,
                        String.class,
                        uriVariables);
        return response.getBody();
    }
}
