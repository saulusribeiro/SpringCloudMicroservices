package br.com.srconsultoria.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.srconsultoria.hrpayroll.entities.Payment;
import br.com.srconsultoria.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId, int days) {
		// O Map é uma Interface , e para usar é necessário uma classe concreta HashMap
		Map<String, String> uriVariables = new HashMap<>();
		
		uriVariables.put("id", ""+ workerId);
		
		Worker worker = restTemplate.getForObject(workerHost +"/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
	
	

}
