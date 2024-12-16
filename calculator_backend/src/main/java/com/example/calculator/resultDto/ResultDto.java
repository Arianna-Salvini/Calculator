package com.example.calculator.resultDto;

public class ResultDto {

    public enum Outcome {
        OK("OK"), //for resul
        KO("KO");// for error

        private final String outcome;

        Outcome(String outcome){
            this.outcome=outcome;
        }

        public String getOutcome(){
            return outcome;
        }
    }

    private Outcome outcome;
    private  double result;
    private  String error;

//Getter and Setter

//    G&S outcome
    public Outcome getOutcome() {
        return outcome;
    }
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
    //    G&S error
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    //    G&S result
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }

}
