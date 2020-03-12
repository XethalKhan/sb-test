package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPersonDAO;
import com.example.demo.model.Person;

@Service("mockService")
public class PersonServiceMockDB implements IPersonService {
	
	private IPersonDAO iPersonDao;

	@Autowired
	public PersonServiceMockDB(@Qualifier("mockDB")IPersonDAO iPersonDao) {
		this.iPersonDao = iPersonDao;
	}

	@Override
	public int addPerson(Person person) {	 
		return iPersonDao.insertPerson(person);
	}

	@Override
	public List<Person> getAll() {
		return iPersonDao.selectAll();
	}

}
