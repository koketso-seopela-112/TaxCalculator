package com.taxcalculator.Taxcalculator.services;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.taxcalculator.Taxcalculator.dao.TaxDao;
import com.taxcalculator.Taxcalculator.entities.Tax;
import com.taxcalculator.Taxcalculator.entities.UserData;
import com.taxcalculator.Taxcalculator.repositories.TaxRepository;
import com.taxcalculator.Taxcalculator.repositories.UserDataRepository;

@Service
public class TaxServiceImpl implements TaxService {

	TaxRepository repository;
	UserDataRepository dataRepo;

	public TaxServiceImpl(TaxRepository repository, UserDataRepository dataRepo) {
		this.repository = repository;
		this.dataRepo = dataRepo;
	}

	@Override
	public double calculatePaye(String type, float salary, int year) {
		salary *= (type.equalsIgnoreCase("yearly")) ? 1 : 12;
		Tax tax = repository.findBySalaryGreaterThanMinimumAndSalaryLessThanMaximumAndYearEqualToTaxYear(salary, year);
		float taxable = salary - tax.getMinimum();
		float tax_rate = Math.round(taxable * (tax.getPercentage() / 100));
		float rate = (tax_rate + tax.getRate()) - 23157;
		return (rate);
	}

	@Override
	public double calculateTaxCredit(int members) {
		return (members >= 1) ? (310.0 * 2) + (209 * (members - 2)) : 310.0;
	}

	@Override
	public UserData UserInput(TaxDao dao) {

		UserData userData = new UserData(dao.getTaxYear(), dao.getAge(), dao.getEarning(), dao.getEarningType(),
				dao.getMembers());
		DecimalFormat f = new DecimalFormat("##.00");
		userData.setPayeYearlyBeforeTaxCred(
				Double.parseDouble(f.format(calculatePaye(dao.getEarningType(), dao.getEarning(), dao.getTaxYear()))));
		userData.setPayeMonthlyBeforeTaxCred(Double
				.parseDouble(f.format(calculatePaye(dao.getEarningType(), dao.getEarning(), dao.getTaxYear()) / 12)));
		userData.setTaxCredit(Double.parseDouble(f.format(calculateTaxCredit(dao.getMembers()))));
		userData.setPayeDue(userData.getPayeMonthlyBeforeTaxCred() - userData.getTaxCredit());
		userData.setTotal(Double
				.parseDouble(f.format(calculateSalary(dao.getEarningType(), dao.getEarning(), userData.getPayeDue()))));
		UserData data = dataRepo.save(userData);
		System.out.println("Record ID: " + data.getId());
		return data;
	}

	@Override
	public double calculateSalary(String type, float salary, double paye) {
		salary /= (type.equalsIgnoreCase("yearly")) ? 12 : 1;
		return salary - paye;
	}

}
