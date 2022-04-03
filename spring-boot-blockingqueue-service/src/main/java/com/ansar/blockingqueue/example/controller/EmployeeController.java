package com.ansar.blockingqueue.example.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ansar.blockingqueue.example.beans.Employee;
import com.ansar.blockingqueue.example.service.EmployeeProducerService;

@RestController
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeProducerService service;
	
	@GetMapping(value = "/employee/{id}")
	public void employee(@PathVariable String id) {
		try {
			service.produceEmployees(new Employee(id, id, id, LocalDateTime.now()));
		} catch(Exception ex) {
			logger.error("**** exception occured in controller while producing employee ****");
		}
	}
	
	@GetMapping(value = "/size")
	public int gePendingEmployeeCount() {
		int retSize = -100;
		try {
			retSize =  service.getPendingEmployeeSize();
		} catch(Exception ex) {
			logger.error("**** exception occured in controller while getting pending employee size ****");
		}
		return retSize;
	}
}
