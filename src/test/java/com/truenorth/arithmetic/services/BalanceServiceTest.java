package com.truenorth.arithmetic.services;

import com.truenorth.arithmetic.models.Balance;
import com.truenorth.arithmetic.repository.BalanceRepository;
import com.truenorth.arithmetic.services.imp.BalanceServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test balance service
 *
 * @author wmonge on 03/2023.
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
public class BalanceServiceTest {
    @InjectMocks
    private BalanceServiceImp balanceServiceImp;

    @Mock
    private BalanceRepository balanceRepository;

    @Test
    public void testGetBalanceByUserOk() {
        Long userId = 1L;
        Balance balance = new Balance();
        balance.setBalance(new BigDecimal(10));
        balance.setUserId(1L);
        Mockito.when(balanceRepository.findById(userId)).thenReturn(Optional.of(balance));
        balanceServiceImp.getBalanceByUser(userId);
        Mockito.verify(balanceRepository).findById(userId);
    }

    @Test
    public void testGetBalanceByUserNotFound() {
        Long userId = 2L;
        Mockito.when(balanceRepository.findById(userId)).thenReturn(Optional.empty());
        Assertions.assertEquals(BigDecimal.ZERO, balanceServiceImp.getBalanceByUser(userId));
    }

    @Test
    void updateWithSuccess() {
        Long userId = 1L;
        Balance balance = new Balance();
        balance.setBalance(new BigDecimal(10));
        balance.setUserId(1L);

        Mockito.when(balanceRepository.findById(userId)).thenReturn(Optional.of(balance));
        Mockito.when(balanceRepository.save(Mockito.any(Balance.class))).thenReturn(balance);

        balanceServiceImp.updateBalanceByUser(userId, new BigDecimal(10));

        assertEquals(BigDecimal.ZERO, balance.getBalance());
    }

}
