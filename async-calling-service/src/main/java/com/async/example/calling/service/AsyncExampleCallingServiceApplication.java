package com.async.example.calling.service;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
public class AsyncExampleCallingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncExampleCallingServiceApplication.class, args);
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

}
