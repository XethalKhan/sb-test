package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.IPersonService;

@RestController
@RequestMapping("/api/hibernateOracle/persons")
public class PersonControllerHibernateOracleDB implements IPersonController {

	private IPersonService iPersonService;

	@Autowired
	public PersonControllerHibernateOracleDB(@Qualifier("hibernateOracleService") IPersonService iPersonService) {
		this.iPersonService = iPersonService;
	}

	@PostMapping
	@Override
	public int addPerson(@RequestBody Person person) {
		return iPersonService.addPerson(person);
	}

	@GetMapping
	@Override
	public List<Person> getAll() {
		return iPersonService.getAll();
	}
	
}
