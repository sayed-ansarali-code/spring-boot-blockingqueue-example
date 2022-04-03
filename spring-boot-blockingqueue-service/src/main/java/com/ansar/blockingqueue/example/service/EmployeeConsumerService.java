package com.ansar.blockingqueue.example.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ansar.blockingqueue.example.beans.Employee;

@Service
public class EmployeeConsumerService {
	Logger logger = LoggerFactory.getLogger(EmployeeConsumerService.class);


	@Autowired
	private BlockingQueue<Employee> employees;
	
	
	@Async
	public void consumeEmployees() {
		try {
			if(employees.size()>= 100) {
				Queue<Employee> employeeQueue = new LinkedList<Employee>();
				employees.drainTo(employeeQueue, 100);
				
				flushToElasticsearch(employeeQueue);
				logger.info("******** Batch of 100 Completed *****");
			}
		} catch(Exception ex) {
			logger.error("**** exception occured in consumer ****", ex);
		}
	}
	
	public void flushToElasticsearch(Queue<Employee> employeeQueue) {
		try {
			employeeQueue.stream().forEach(employee -> {
				logger.info("Flushed employeee: " + employee.getEmployeeId());
			});
		} catch(Exception ex) {
			logger.error("**** exception occured while flushing employees **** ", ex);
		}
	}
	
}
