package com.taxcalculator.Taxcalculator.dao;

public class TaxDao {
	private int taxYear;
	private int Age;
	private float earning;
	private String earningType;
	private int members;
	private double taxCredit;
	private double payeMonthlyBeforeTaxCred;
	private double payeYearlyBeforeTaxCred;
	private double payeDue;
	private double total;


	public double getTaxCredit() {
		return taxCredit;
	}
	public void setTaxCredit(double taxCredit) {
		this.taxCredit = taxCredit;
	}
	public double getPayeMonthlyBeforeTaxCred() {
		return payeMonthlyBeforeTaxCred;
	}
	public void setPayeMonthlyBeforeTaxCred(double payeMonthlyBeforeTaxCred) {
		this.payeMonthlyBeforeTaxCred = payeMonthlyBeforeTaxCred;
	}
	public double getPayeYearlyBeforeTaxCred() {
		return payeYearlyBeforeTaxCred;
	}
	public void setPayeYearlyBeforeTaxCred(double payeYearlyBeforeTaxCred) {
		this.payeYearlyBeforeTaxCred = payeYearlyBeforeTaxCred;
	}
	public double getPayeDue() {
		return payeDue;
	}
	public void setPayeDue(double payeDue) {
		this.payeDue = payeDue;
	}
	public TaxDao() {
		// TODO Auto-generated constructor stub
	}
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public TaxDao(int taxYear, int age, float earning, String earningType, int members) {
		super();
		this.taxYear = taxYear;
		Age = age;
		this.earning = earning;
		this.earningType = earningType;
		this.members = members;
	}

	public int getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public float getEarning() {
		return earning;
	}

	public void setEarning(float earning) {
		this.earning = earning;
	}

	public String getEarningType() {
		return earningType;
	}

	public void setEarningType(String earningType) {
		this.earningType = earningType;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

}