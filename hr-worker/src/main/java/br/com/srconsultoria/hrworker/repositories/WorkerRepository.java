package br.com.srconsultoria.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.srconsultoria.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
