package com.example.calculator.entity;

import jakarta.persistence.*;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import java.time.LocalDateTime;


@Entity
/*
 * This class represents the 'calculation_history' table in the database.
 * It is used to store the history of all calculations performed by the application.
 */

@Table(name = "calculator_record") //for name of the db table
public class CalculatorRecord {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Auto increment
    private Long id;

    @Column(nullable = false)
    private double numerator;

    @Column(nullable = false)
    private double denominator;

    @Column(nullable = false)
    private char operator;

    @Column
    private String result;

    @Column
    private String error;

    @Column
    private LocalDateTime timestamp;

    // Setter and Getter

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setNumerator(double numerator) {
        this.numerator = numerator;
    }
    public double getNumerator() {
        return numerator;
    }

    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }
    public double getDenominator() {
        return denominator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
    public char getOperator() {
        return operator;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public String getResult() {
        return result;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }


}



