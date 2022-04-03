package com.async.example.calling.service.controller.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.async.example.calling.service.client.EmployeeServiceClient;

@Service
public class EmployeeCallingService implements ICallingService{

	Logger logger = LoggerFactory.getLogger(EmployeeCallingService.class);

	@Autowired
	EmployeeServiceClient client;
	
	@Async
	@Override
	public void callExternalService(String id) {
//		logger.info("Start Service - calling employee service: {}", id);
		client.employee(id);
//		logger.info("End Service - calling employee service: {}", id);
	}

}
