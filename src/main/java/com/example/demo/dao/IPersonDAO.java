package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;

public interface IPersonDAO {

	int insertPerson(String id, String name);
	
	default int insertPerson(Person person) {
		String id = UUID.randomUUID().toString();
		return insertPerson(id, person.getName());
	}
	
	List<Person> selectAll();
	
}
