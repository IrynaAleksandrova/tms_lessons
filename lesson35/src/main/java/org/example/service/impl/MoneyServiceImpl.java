package org.example.service.impl;

import lombok.Data;
import org.example.service.MoneyService;
import org.springframework.stereotype.Service;

@Data
@Service
public class MoneyServiceImpl implements MoneyService {

    private int money;

    @Override
    public void sumMoney() {
        money = money * 2;
    }

    @Override
    public void minMoney(int count) {
        money = money - count;
    }
}
