package com.fuzzysets.bank.dao;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankDto {
    String name;
    Integer target;
    Integer months;
    Integer risk;
    Integer percent;
}
