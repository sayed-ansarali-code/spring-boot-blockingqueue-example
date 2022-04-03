package com.ansar.blockingqueue.example.beans;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private String employeeId;
	private String employeeName;
	private String emplyeeDesignation;
	private LocalDateTime lastUpdatedTimestamp;
}
