package com.taxcalculator.Taxcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.text.DecimalFormat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.taxcalculator.Taxcalculator.entities.Tax;
import com.taxcalculator.Taxcalculator.repositories.TaxRepository;
import com.taxcalculator.Taxcalculator.services.TaxServiceImpl;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class TaxcalculatorApplicationTests {

	@Autowired
	private TaxRepository repo;

	@Autowired
	private TaxServiceImpl service;

	@Test
	public void testRangeCheck() {
		Tax tax = repo.findBySalaryGreaterThanMinimumAndSalaryLessThanMaximum(360000);
		System.out.println("The Minimum is: " + tax.getMinimum() + " And the Maximum is: " + tax.getMaximum());
		assertThat(tax).isNotNull();
	}

	@Test
	public void testRangeCheckAndYear() {
		Tax tax = repo.findBySalaryGreaterThanMinimumAndSalaryLessThanMaximumAndYearEqualToTaxYear(360000, 2021);
		System.out.println("The Minimum is: " + tax.getMinimum() + " And the Maximum is: " + tax.getMaximum()
				+ " And Year is: " + tax.getTaxYear());
		assertThat(tax).isNotNull();
	}
	/*
	 * @Test public void testCalculation() { double tax_deduction
	 * =service.CalculateTax(420000, 2021); DecimalFormat f = new
	 * DecimalFormat("##.00"); System.out.println("Tax Deduction: " +
	 * f.format(tax_deduction)); assertNotEquals(tax_deduction, 0); }
	 */}
