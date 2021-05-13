package com.taxcalculator.Taxcalculator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taxcalculator.Taxcalculator.dao.TaxDao;
import com.taxcalculator.Taxcalculator.entities.Tax;
import com.taxcalculator.Taxcalculator.entities.UserData;
import com.taxcalculator.Taxcalculator.repositories.TaxRepository;
import com.taxcalculator.Taxcalculator.services.TaxServiceImpl;

@Controller
public class AppController {
	@Autowired
	private TaxServiceImpl service;
	@Autowired
	private TaxRepository repo;

	@RequestMapping("/")
	public String showMainPage(Model model) {
		List<Tax> taxes = repo.findAll();
		model.addAttribute("tax", new TaxDao());
		model.addAttribute("taxes", taxes);
		return "index";
	}

	@PostMapping("/results")
	public String renderCalculate(@ModelAttribute TaxDao dao, Model model) {
		UserData result = service.UserInput(dao);
		model.addAttribute("tax", result);
		return "index/";
	}
}
