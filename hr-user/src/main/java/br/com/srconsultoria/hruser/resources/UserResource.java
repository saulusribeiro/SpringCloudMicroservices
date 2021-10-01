package br.com.srconsultoria.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.srconsultoria.hruser.entities.User;
import br.com.srconsultoria.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

		@Autowired
		private UserRepository UserRepository;
	
		@GetMapping(value = "/{id}")
		public ResponseEntity<User> findById(@PathVariable Long id) {

			User obj = UserRepository.findById(id).get();

			return ResponseEntity.ok(obj);

		}
		
		// O atributo que se coloca ? é o @RequestParam
		@GetMapping(value = "/search")
		public ResponseEntity<User> findByEmail(@RequestParam String email) {

			User obj = UserRepository.findByEmail(email);

			return ResponseEntity.ok(obj);

		}

}
