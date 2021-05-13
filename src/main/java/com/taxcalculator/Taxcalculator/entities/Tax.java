package com.taxcalculator.Taxcalculator.entities;

import javax.persistence.*;

@Entity
@Table(name = "taxable_yearly")
public class Tax {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int taxYear;
	private float minimum;
	private float maximum;
	private float percentage;
	private float rate;

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Tax() {
		// TODO Auto-generated constructor stub
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

	public float getMinimum() {
		return minimum;
	}

	public void setMinimum(float minimum) {
		this.minimum = minimum;
	}

	public float getMaximum() {
		return maximum;
	}

	public void setMaximum(float maximum) {
		this.maximum = maximum;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

}
