package com.example.calculator.repository;

import com.example.calculator.entity.CalculatorRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculatorHistoryRepository extends JpaRepository<CalculatorRecord, Long> {

}
