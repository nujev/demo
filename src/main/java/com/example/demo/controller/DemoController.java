package com.example.demo.controller;

import com.example.demo.remoto.service.Demo1Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RibbonClient(name = "ocp")
public class DemoController {

    private final Demo1Service demo1;
    private Logger log;

    @Autowired
    public DemoController(Demo1Service demo1) {
        this.demo1 = demo1;
        log = Logger.getLogger(getClass().getName());
    }

    @RequestMapping("/{name}")
    public @ResponseBody
    String hola(@PathVariable String name) {
        log.info("===== hola " + name + " =====");
        return "hola " + name;
    }

    @RequestMapping("/")
    public @ResponseBody
    String demo() {
        log.info("===== demo controller =====");
        String val = demo1.demo();
        return "demo controller, demo1 = " + val;
    }

}
