package com.async.example.calling.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "spring-boot-blockingqueue-service", url = "http://localhost:8084")
public interface EmployeeServiceClient {
	
	@GetMapping(value = "/employee/{id}")
	public void employee(@PathVariable String id);

}
