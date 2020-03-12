package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("hibernateOracleDB")
public class HibernateOracleDB implements IPersonDAO {

	@Override
	public int insertPerson(String id, String name) {
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Person(id, name));
		session.getTransaction().commit();
		session.close();
		return 1;
	}

	@Override
	public List<Person> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
