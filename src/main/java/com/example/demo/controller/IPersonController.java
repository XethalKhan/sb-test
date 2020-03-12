package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Person;

public interface IPersonController {

	int addPerson(Person person);

	List<Person> getAll();
	
}
