package com.example.calculator.rest;

import com.example.calculator.entity.CalculatorRecord;
import com.example.calculator.exception.CalculatorException;
import com.example.calculator.resultDto.ResultDto;
import com.example.calculator.service.CalculatorService;
import com.example.calculator.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //mark this class as a REST controller, where methods return data (like JSON) instead of views.
@RequestMapping("api/calculator") //define the base path of all operations
@CrossOrigin
public class CalculatorController {

    @Autowired // injection of CalculatorService into the controller, allows the use of its methods for mathematical operation
    private CalculatorService calculatorService;

    @Autowired
    private HistoryService historyService;


    // Handle GET request for sum
    @GetMapping("/sum")   //Associate a URL and Http Get request with the logic methods
    @ResponseStatus(HttpStatus.OK)
    public ResultDto sum(@RequestParam double a, @RequestParam double b){   //capture query parameters from URL and pass them as methods parameters
        // Call method sum of calculatorService and return the result
        return calculatorService.sum(a, b);
    }

    // Handle GET request for subtraction
    @GetMapping("/sub")
    @ResponseStatus(HttpStatus.OK)
    public ResultDto sub(@RequestParam double a, @RequestParam double b){
        return calculatorService.subtraction(a, b);
    }

    // Handle GET request for multiplication
    @GetMapping("/multiply")
    @ResponseStatus(HttpStatus.OK)
    public ResultDto multiply(@RequestParam double a, @RequestParam double b){
        return calculatorService.multiplication(a, b);
    }

    // Handle GET request for division
    @GetMapping("/div")
//  Wrapping all into ResponseEntity
    public ResponseEntity <ResultDto> div(@RequestParam double a, @RequestParam double b) {
        try{
            // Call division result from service
            ResultDto result =  calculatorService.division(a, b);

            // return HTTP response with:
            // - .ok = Status 200
            // - (result) = get the result body (ResultDto)
            return ResponseEntity.status(HttpStatus.OK).body(result);

      } catch (CalculatorException calculatorException){

          ResultDto resultDto = new ResultDto();
             resultDto.setOutcome(ResultDto.Outcome.KO);
             resultDto.setError(calculatorException.getMessage());

            // return HTTP response with:
            // - .badRequest = Status 200
            // - (resultDto) = get the result body for error (ResultDto)
          return ResponseEntity.badRequest().body(resultDto);
      }

    }

   @GetMapping("/history")
   public List<CalculatorRecord> getHistory(){
       return historyService.getHistory();
   }

}
