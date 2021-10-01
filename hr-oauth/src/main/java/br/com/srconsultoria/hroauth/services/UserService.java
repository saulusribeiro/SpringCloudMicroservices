package br.com.srconsultoria.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.srconsultoria.hroauth.entities.User;
import br.com.srconsultoria.hroauth.feignclients.UserFeignClient;
/*
 * O serviço se comunica com o cliente feign, e busca o usuario por email
 * */

@Service
public class UserService {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		
		User user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			throw new IllegalArgumentException("Email not found");
		}
		return user;
	}
}
