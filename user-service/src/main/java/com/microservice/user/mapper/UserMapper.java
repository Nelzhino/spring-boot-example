package com.microservice.user.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.microservice.user.model.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setNombre(rs.getString("nombre"));
		user.setApellido(rs.getString("apellido"));
		user.setFechaNacimiento(rs.getDate("fechaNacimiento"));
		user.setEmail(rs.getString("email"));
		
		return user;
	}

}
