package com.example.calculator.service;

import com.example.calculator.entity.CalculatorRecord;
import com.example.calculator.repository.CalculatorHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private CalculatorHistoryRepository calculatorHistoryRepository;

    @Transactional(value = Transactional.TxType.REQUIRES_NEW )
    public void saveHistory(double a, double b, char operator, String result, String error){

//        try{
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        CalculatorRecord history = new CalculatorRecord();
        history.setNumerator(a);
        history.setDenominator(b);
        history.setOperator(operator);
        history.setResult(result);
        history.setError(error);
        history.setTimestamp(LocalDateTime.now());
        calculatorHistoryRepository.save(history);
    }

    public List<CalculatorRecord> getHistory(){
        return calculatorHistoryRepository.findAll();
    }
}
