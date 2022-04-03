package com.ansar.blockingqueue.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.ansar.blockingqueue.example.beans.Employee;

/**
 * http://localhost:8082/employee/1
 * http://localhost:8084/size
 * 
 * @author User
 *
 */
@SpringBootApplication
@EnableAsync
public class SpringEventExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventExampleApplication.class, args);
	}
	
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5); // set the core pool size
		executor.setMaxPoolSize(10); // max pool size
		executor.setThreadNamePrefix("ext-async-"); // give an optional name to your threads
		executor.initialize();
		return executor;
	}
	
	@Bean
	public BlockingQueue<Employee> employees() {
		BlockingQueue<Employee> employees = new ArrayBlockingQueue<>(1000);
		return employees;
	}

}
