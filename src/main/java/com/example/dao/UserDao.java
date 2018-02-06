/*package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.DataSet;

@Controller
public class UserDao
{
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@RequestMapping("/insert")  
	public void insert(DataSet data)
	{
		String sql="INSERT INTO DATASET(TYPE, VALID, VALUE) values (?, ?, ?)";
		jdbcTemplate.update(sql,data.getType(),data.isValid(),data.getValue());
	}
	
	public List<DataSet> getDataByType(String Type)
	{
		String sql="SELECT * FROM DATASET WHERE TYPE=?";
		RowMapper<DataSet> rowMapper = new BeanPropertyRowMapper<DataSet>(DataSet.class);
		return jdbcTemplate.queryForObject(sql, rowMapper,Type);
	}
	
	
}*/