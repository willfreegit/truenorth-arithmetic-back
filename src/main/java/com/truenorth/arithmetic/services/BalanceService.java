package com.truenorth.arithmetic.services;

import java.math.BigDecimal;

public interface BalanceService {
    public BigDecimal getBalanceByUser(Long userId);
    public boolean updateBalanceByUser(Long userId, BigDecimal cost);
}
