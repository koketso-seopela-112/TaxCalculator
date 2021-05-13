package com.taxcalculator.Taxcalculator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxcalculator.Taxcalculator.entities.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {
	@Query("SELECT t FROM Tax t WHERE  t.minimum < :salary AND t.maximum > :salary")
	Tax findBySalaryGreaterThanMinimumAndSalaryLessThanMaximum(float salary);
	@Query("SELECT t FROM Tax t WHERE t.minimum < :salary AND t.maximum > :salary AND t.taxYear = :year")
	Tax findBySalaryGreaterThanMinimumAndSalaryLessThanMaximumAndYearEqualToTaxYear(float salary,int year);
	@Query("SELECT t FROM Tax t WHERE t.taxYear = :year")
	List<Tax> findByYear(int year);
}
