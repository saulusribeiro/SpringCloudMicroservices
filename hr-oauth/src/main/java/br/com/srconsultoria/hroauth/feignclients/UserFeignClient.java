package br.com.srconsultoria.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.srconsultoria.hroauth.entities.User;

/*
 * O cliente feign se comunica com o microserviço hr-user
 * */

@Component
@FeignClient(name="hr-user", path = "/users")
public interface UserFeignClient {
	
		@GetMapping(value = "/search")
		ResponseEntity<User> findByEmail(@RequestParam String email);

}
