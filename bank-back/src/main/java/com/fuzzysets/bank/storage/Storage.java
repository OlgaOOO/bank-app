package com.fuzzysets.bank.storage;

import com.fuzzysets.bank.dao.BankDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Storage {
    private final Map<Integer, List<BankDto>> deposits = Map.of(
            20, List.of(
                    new BankDto("Ускоренный", 1, 1, 1, 8),
                    new BankDto("Скорый", 2, 2, 1, 5)
            ),
            40, List.of(
                    new BankDto("Трёхмесячный", 4, 7, 4, 14),
                    new BankDto("Увеличенный", 3, 8, 7, 15)
            ),
            60, List.of(
                    new BankDto("Годовой", 7, 12, 6, 18),
                    new BankDto("X-годовой", 6, 14, 6, 17)
            ),
            80, List.of(
                    new BankDto("Полуторагодовой", 8, 18, 7, 21),
                    new BankDto("Длительный", 9, 20, 7, 23)
            ),
            100, List.of(
                    new BankDto("Долгосрочный", 10, 36, 10, 27)
            )
    );

    public List<BankDto> getDeposit(Integer key) {
        return deposits.get(key);
    }

    public List<BankDto> getDeposits() {
        List<BankDto> deposits = new ArrayList<>();
        this.deposits.values().forEach(deposits::addAll);
        return deposits;
    }

    public boolean addDeposit(Integer key, BankDto deposit) {
        return deposits.get(key).add(deposit);
    }

}
