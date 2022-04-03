package com.async.example.calling.service.controller;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.example.calling.service.controller.svc.ICallingService;

@RestController
public class CallingController {
	
	Logger logger = LoggerFactory.getLogger(CallingController.class);

	@Autowired
	private ICallingService employeeCallingService;


	@RequestMapping(value = "/employee/{id}")
	public void employee(@PathVariable String id) {
		logger.info("Start Controller - calling employee service: {}", id);
		//Async call: executed in a separate thread
		IntStream.rangeClosed(1, 1050).forEach( i -> {
			employeeCallingService.callExternalService(Integer.valueOf(i).toString());
		});
		logger.info("End Controller - calling employee service: {}", id);
	}

}
