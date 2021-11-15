package com.springbootdatabase.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbootdatabase.entities.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper{

		//@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException{
			Person person = new Person();
			return person;
		}

		@Override
		public int[] getRowsForPaths(TreePath[] path) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
	}
	
	//Select all persons
	public List<Person> findAll(){
		return jdbcTemplate.query("Select * from Person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	//Select a Person by Id
		@SuppressWarnings("deprecation")
		public Person findById(int id){
			return jdbcTemplate.queryForObject("Select * from Person where id=?",
					new Object[] {id},
					new BeanPropertyRowMapper<Person>(Person.class));
		}
	//Delete by Id
	public int deleteById(int id){
		return jdbcTemplate.update("Delete  from Person where id=?",
				new Object[] {id});
	}
	
	//Insert into Person
	public int insertPerson(Person person){
		return jdbcTemplate.update
				("Insert into Person(id, name, location, birth_Date) Values(?,?,?,?)",
				new Object[] {person.getId(),
						person.getName(),
						person.getLocation(),
						new Timestamp(person.getBirthDate().getTime())});
	}
	
	//Update into Person
		public int updatePerson(Person person){
			return jdbcTemplate.update
					("Update  Person "
					+" set name=?, location=?, birth_Date=?"
					+" where id=?",
					new Object[] {
							person.getName(),
							person.getLocation(),
							person.getBirthDate(),
							person.getId(),});
		}

}
