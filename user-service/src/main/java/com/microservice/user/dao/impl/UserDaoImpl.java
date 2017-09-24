package com.microservice.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.microservice.user.dao.UserDao;
import com.microservice.user.mapper.UserMapper;
import com.microservice.user.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate temp;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		temp = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public int insert(User user) {
		String sql = "INSERT INTO user (id, nombre, apellido, fechaNacimiento, email) VALUES(:id, :nombre, :apellido, :fechaNacimiento, :email)";
		return temp.update(sql, new BeanPropertySqlParameterSource(user));

	}

	@Override
	public User findById(int id) {
		String sql = "SELECT * FROM user WHERE id=:id";
		return temp.queryForObject(sql, new MapSqlParameterSource("id", id), new UserMapper());
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		return temp.query(sql, new UserMapper());
	}

	@Override
	public int update(User user) {
		String sql = "UPDATE user SET nombre=:nombre, apellido=:apellido, fechaNacimiento=:fechaNacimiento, email=:email WHERE id=:id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nombre", user.getNombre());
		params.put("apellido", user.getApellido());
		params.put("fechaNacimiento", user.getFechaNacimiento());
		params.put("email", user.getEmail());
		params.put("id", user.getId());

		return temp.update(sql, params);
	}

	@Override
	public boolean isUser(int id) {
		String sql = "SELECT COUNT(*) FROM user WHERE id=:id";
		return temp.queryForObject(sql, new MapSqlParameterSource("id", id), Integer.class) > 0;
	}

}
