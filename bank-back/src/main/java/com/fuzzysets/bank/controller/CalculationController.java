package com.fuzzysets.bank.controller;

import com.fuzzysets.bank.dao.BankDto;
import com.fuzzysets.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/bank/deposit")
public class CalculationController {
    private final BankService service;

    @PostMapping
    public List<BankDto> getDeposit(@RequestBody BankDto dto) {
        log.info("POST /bank/deposit");
        return service.getDeposit(dto);
    }

    @GetMapping
    public List<BankDto> getAllDeposits() {
        log.info("GET /bank/deposit");
        return service.getAllDeposits();
    }

}
