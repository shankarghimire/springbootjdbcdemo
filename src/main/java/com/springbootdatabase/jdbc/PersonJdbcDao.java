package com.springbootdatabase.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbootdatabase.entities.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
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

}
