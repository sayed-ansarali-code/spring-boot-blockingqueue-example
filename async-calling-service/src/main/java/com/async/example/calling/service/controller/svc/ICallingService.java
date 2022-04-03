package com.async.example.calling.service.controller.svc;

import org.springframework.web.bind.annotation.PathVariable;

public interface ICallingService {

	public void callExternalService(@PathVariable String name);
}
