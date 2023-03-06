package com.truenorth.arithmetic.services;

import java.math.BigDecimal;

/**
 * Balance service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
public interface BalanceService {
    public BigDecimal getBalanceByUser(Long userId);
    public boolean updateBalanceByUser(Long userId, BigDecimal cost);
}
