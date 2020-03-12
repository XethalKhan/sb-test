package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("oracleDB")
public class OracleDB implements IPersonDAO {

	private static final String url = "xxx";
	private static final String username = "xxx";
	private static final String password = "xxx";
	
	public Connection getConnection() {
		Connection db = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			db = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return db;
	}
	
	@Override
	public int insertPerson(String id, String name) {
		Connection db = getConnection();
		if (db == null) {
			return 0;
		}
		
		int updatedRows = 0;
		try {
			String query = ""
					+ "INSERT INTO tbl_persons(id, name) "
					+ "VALUES(?, ?)";
			PreparedStatement pstm = db.prepareStatement(query);
			pstm.setString(1, id.toString());
			pstm.setString(2, name);
			updatedRows = pstm.executeUpdate();
			pstm.close();
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
			updatedRows = 0;
		}
		
		return updatedRows;
	}

	@Override
	public List<Person> selectAll() {
		List<Person> persons = new ArrayList<Person>();
		
		Connection db = getConnection();
		if (db == null) {
			return persons;
		}
		
		try {
			String query = ""
					+ "SELECT id, name "
					+ "FROM tbl_persons";
			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				persons.add(new Person(rs.getString(1), rs.getString(2)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return persons;
	}
	
}
