package com.microservice.user.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.UserDTO;
import com.microservice.user.model.User;
import com.microservice.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/usuario/crear", method = RequestMethod.POST)
	public UserDTO crear(@RequestBody User user) {
		int id = userService.crear(user);
		UserDTO userDto = resultadoTransaccion(user, id);
		return userDto;
	}

	@RequestMapping(value = "/usuario/editar", method = RequestMethod.PUT)
	public UserDTO actualizar(@RequestBody User user) {
		int id = userService.actualizar(user);
		UserDTO userDto = resultadoTransaccion(user, id);
		return userDto;
	}
	
	@RequestMapping(value = "/usuario/buscar/{id}", method = RequestMethod.GET)
	public User buscarPorId(@PathVariable("id") int id){
		return userService.buscar(id);
	}
	
	@RequestMapping(value = "/usuario/buscar", method = RequestMethod.GET)
	public List<User> buscar(){
		return userService.buscarTodos();
	}
	
	private UserDTO resultadoTransaccion(User user, int id) {
		UserDTO userDto = new UserDTO();
		int code = 0;
		String descripcion = "No se guardo";
		if (id > 0) {
			code = 1;
			descripcion = "Se guardo";
		}
		userDto.setIdUser(user.getId());
		userDto.setNombreCompleto(String.format("%s %s", user.getNombre(), user.getApellido()));
		userDto.setCode(code);
		userDto.setDescription(descripcion);
		return userDto;
	}
}
