package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Person;

public interface IPersonService {

	int addPerson(Person person);
	
	List<Person> getAll();
	
}
