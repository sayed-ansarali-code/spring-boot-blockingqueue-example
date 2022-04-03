package com.ansar.blockingqueue.example.service;

import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ansar.blockingqueue.example.beans.Employee;

@Service
public class EmployeeProducerService {
	
	Logger logger = LoggerFactory.getLogger(EmployeeProducerService.class);

	@Autowired
	private BlockingQueue<Employee> employees;
	
	@Autowired
	private EmployeeConsumerService consumerService;
	
	@Async
	public void produceEmployees(Employee employee) {
		try {
			boolean isSuccess = employees.offer(employee);
			if(isSuccess) {
				if(employees.size()>= 100) {
					consumerService.consumeEmployees();
				}
			} else {
				logger.info("*******Could not add employee to blockingQueue****** " + employee.getEmployeeId());
			}
		}catch(Exception ex) {
			logger.error("**** exception occured in producer ****", ex);
		}
	}
	
	public int getPendingEmployeeSize() {
		return employees.size();
	}
	
}
