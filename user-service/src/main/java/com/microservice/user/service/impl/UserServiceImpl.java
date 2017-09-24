package com.microservice.user.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.user.dao.UserDao;
import com.microservice.user.model.User;
import com.microservice.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	private boolean validacionDatosUsuario(User user) {
		boolean flag = false;
		if (user != null && user.getId() > 0 && !user.getNombre().isEmpty() && !user.getApellido().isEmpty()
				&& !user.getEmail().isEmpty()) {
			flag = true; 
		}
		
		return flag;
	}

	@Override
	public int crear(User user) {
		int filasAfectadas = 0;
		if(validacionDatosUsuario(user) && !this.estaUsuario(user.getId())){
			filasAfectadas = userDao.insert(user);
		}
		return filasAfectadas;
	}

	@Override
	public User buscar(int id) {
		User user = null;
		if (id > 0) {
			user = userDao.findById(id);
		}
		return user;
	}

	@Override
	public List<User> buscarTodos() {
		List<User> usuarios = userDao.findAll();
		return usuarios;
	}

	@Override
	public int actualizar(User user) {
		int filaAfectada = 0;
		if (validacionDatosUsuario(user) && this.estaUsuario(user.getId())) {
			filaAfectada = userDao.update(user);
		}
		return filaAfectada;
	}

	@Override
	public boolean estaUsuario(int id) {
		boolean flag = false;
		if (id > 0) {
			flag = userDao.isUser(id);
		}
		return flag;
	}
	
	

}
