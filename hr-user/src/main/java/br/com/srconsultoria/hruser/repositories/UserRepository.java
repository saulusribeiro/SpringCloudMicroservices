package br.com.srconsultoria.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.srconsultoria.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
