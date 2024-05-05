package com.fuzzysets.bank.service;

import com.fuzzysets.bank.dao.BankDto;
import com.fuzzysets.bank.storage.Storage;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final Storage storage;
    @Value("classpath:ruls.fcl")
    private Resource file;
    private FIS fis;

    @PostConstruct
    private void loadFis() {
        try (InputStream is = file.getInputStream()) {
            fis = FIS.load(is, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<BankDto> getDeposit(BankDto dto) {
//        showGraphs(fis);
        fis.setVariable("target", dto.getTarget());
        fis.setVariable("months", dto.getMonths());
        fis.setVariable("risk", dto.getRisk());
        fis.setVariable("percent", dto.getPercent());

        fis.evaluate();

        double depositRecommendation = fis.getVariable("depositRecommendation").defuzzify();
        System.out.println("depositRecommendation " + depositRecommendation);
        return storage.getDeposit(getKey(depositRecommendation));
    }

    public List<BankDto> getAllDeposits() {
        List<BankDto> deposits = storage.getDeposits();
        deposits.sort(Comparator.comparingInt(BankDto::getMonths));
        return deposits;
    }

    private void showGraphs() {
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);
    }

    private Integer getKey(double depositRecommendation) {
        int[] deposits = {20, 40, 60, 80, 100};
        for (int deposit : deposits) {
            if (depositRecommendation <= deposit) {
                return deposit;
            }
        }
        return deposits[deposits.length - 1];
    }
}
