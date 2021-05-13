package com.taxcalculator.Taxcalculator.services;

import com.taxcalculator.Taxcalculator.dao.TaxDao;
import com.taxcalculator.Taxcalculator.entities.UserData;

public interface TaxService {

	public double calculatePaye(String type, float salary, int year);

	public double calculateTaxCredit(int members);

	public UserData UserInput(TaxDao dao);

	public double calculateSalary(String type, float salary, double paye);
}
