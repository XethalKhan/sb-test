package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("mockDB")
public class MockDB implements IPersonDAO {

	private static List<Person> tbl_persons = new ArrayList<Person>();
	
	@Override
	public int insertPerson(String id, String name) {
		tbl_persons.add(new Person(id, name));
		return 1;
	}

	@Override
	public List<Person> selectAll() {
		return tbl_persons;
	}

}
