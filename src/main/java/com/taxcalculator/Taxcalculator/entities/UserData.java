package com.taxcalculator.Taxcalculator.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_sigreg")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int taxYear;
	private int age;
	private float earning;
	private String earningType;
	private int members;
	private double taxCredit;
	private double payeMonthlyBeforeTaxCred;
	private double payeYearlyBeforeTaxCred;
	private double payeDue;
	private double total;

	public UserData(int taxYear, int age, float earning, String earningType, int members) {
		this.taxYear = taxYear;
		this.age = age;
		this.earning = earning;
		this.earningType = earningType;
		this.members = members;
	}

	public UserData() {
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getTaxCredit() {
		return taxCredit;
	}

	public void setTaxCredit(double taxCredit) {
		this.taxCredit = taxCredit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
