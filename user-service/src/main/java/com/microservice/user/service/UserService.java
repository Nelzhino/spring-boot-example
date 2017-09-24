package com.microservice.user.service;

import java.util.List;

import com.microservice.user.model.User;


public interface UserService {
	
	int crear(User user);

	User buscar(int id);

	List<User> buscarTodos();

	int actualizar(User user);
	
	boolean estaUsuario(int id);
	
}
