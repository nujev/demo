package com.example.demo.remoto.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("demo-1")
public interface Demo1Repository {

	@RequestMapping("/")
    @ResponseBody
    String demo();

}
