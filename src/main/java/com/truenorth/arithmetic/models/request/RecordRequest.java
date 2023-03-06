package com.truenorth.arithmetic.models.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@Data
public class RecordRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Integer page;
    @NotNull
    private Integer size;
    private Filters filters;

    @Data
    public static class Filters{
        @NotNull
        private String filtersId;
        private Long operationId;
        private String operationResponse;
        private Date fini;
        private Date fend;
    }
}
