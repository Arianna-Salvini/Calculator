package com.example.calculator.service;

import com.example.calculator.exception.CalculatorException;
import com.example.calculator.resultDto.ResultDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CalculatorService {

    @Autowired
    private HistoryService historyService;
    /**
     * Add the two double.
     *
     * @param a first double (numerator)
     * @param b second double (denominator)
     * @return the sum of a and b
     */


    public ResultDto sum(double a, double b) {
        historyService.saveHistory(a,b, '+', String.valueOf(a+b), null);
        double result =  a + b;

        ResultDto resultDto = new ResultDto();
        resultDto.setOutcome(ResultDto.Outcome.OK);
        resultDto.setResult(result);

        return resultDto;
    }

    /**
     * Subtract the second double from the first one.
     *
     * @param a first double (numerator)
     * @param b second double (denominator)
     * @return the resul of a minus b
     */

    public ResultDto subtraction(double a, double b) {
        historyService.saveHistory(a,b, '-', String.valueOf(a-b), null);
        double result= a - b;

        ResultDto resultDto =new ResultDto();
        resultDto.setOutcome(ResultDto.Outcome.OK);
        resultDto.setResult(result);

        return resultDto;
    }

    /**
     * Multiply the two double.
     *
     * @param a first double (numerator)
     * @param b second double (denominator)
     * @return the product of a and b
     */

    public ResultDto multiplication(double a, double b) {
        historyService.saveHistory(a,b, '*', String.valueOf(a*b), null);
        double result =  a * b;

        ResultDto resultDto =new ResultDto();
        resultDto.setOutcome(ResultDto.Outcome.OK);
        resultDto.setResult(result);

        return resultDto;
    }

    /**
     * Divide first double by the second one.
     * .
     * If the second double (denominator) is zero, an ArithmeticException is caught,
     * an error message is printed and zero is returned as result.
     *
     * @param a first double (numerator)
     * @param b second double (denominator)
     * @return the resul of a by b as a double, or 0 if division is by 0
     */

    public ResultDto division(double a, double b) throws CalculatorException {
        if (b == 0) {
            historyService.saveHistory(a,b, '/', "0", CalculatorException.ErrorCode.DivByZero.getMessage());
           throw new CalculatorException(CalculatorException.ErrorCode.DivByZero);
        }else if (b >= 1000){
            historyService.saveHistory(a,b, '/', "0", CalculatorException.ErrorCode.DivByMax.getMessage());
            throw new CalculatorException(CalculatorException.ErrorCode.DivByMax);
        }


        historyService.saveHistory(a,b, '/', String.valueOf(a/b), null);
        double result = a / b;

        ResultDto resultDto = new ResultDto();
        resultDto.setOutcome(ResultDto.Outcome.OK);
        resultDto.setResult(result);

        return resultDto;
    }


}

