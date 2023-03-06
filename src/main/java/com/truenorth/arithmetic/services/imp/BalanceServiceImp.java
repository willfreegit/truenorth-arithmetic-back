package com.truenorth.arithmetic.services.imp;

import com.truenorth.arithmetic.models.Balance;
import com.truenorth.arithmetic.repository.BalanceRepository;
import com.truenorth.arithmetic.services.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BalanceServiceImp implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Override
    public BigDecimal getBalanceByUser(Long userId) {
        Optional<Balance> balanceOptional = balanceRepository.findById(userId);
        if(balanceOptional.isPresent()){
            Balance balance = balanceOptional.get();
            return balance.getBalance();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public boolean updateBalanceByUser(Long userId, BigDecimal cost) {
        Optional<Balance> balanceOptional = balanceRepository.findById(userId);
        if(balanceOptional.isPresent()){
            try{
                Balance balance = balanceOptional.get();
                balance.setBalance(balance.getBalance().subtract(cost));
                balanceRepository.save(balance);
                return true;
            } catch (Exception ex){
                return false;
            }
        }
        return false;
    }
}
