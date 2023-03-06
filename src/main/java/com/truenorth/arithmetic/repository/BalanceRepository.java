package com.truenorth.arithmetic.repository;

import java.math.BigDecimal;

public interface BalanceRepository {
    public BigDecimal getCurrentBalance();
    public boolean updateBalance();
}
