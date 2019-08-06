package com.example.demo.remoto.service;

import com.example.demo.remoto.repository.Demo1Repository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class Demo1Service {
	private Logger log = Logger.getLogger(getClass().getName());

	private final Demo1Repository demo1;

	@Autowired
	public Demo1Service(Demo1Repository demo1) {
		this.demo1 = demo1;
	}

	@HystrixCommand(fallbackMethod = "demoRemotoFallback")
	public String demo() {
		log.info("===== demo remoto =====");
		try {
			return demo1.demo();
		} catch (Exception e) {
			e.printStackTrace();
			log.severe("===== Error =====");
			// TODO: handle exception
		}
		return null;
	}

	public String demoRemotoFallback() {
		log.info("===== demo remoto fallback =====");
		return "demoRemotoFallback";
	}

}
