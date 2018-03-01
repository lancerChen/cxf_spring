package com.cxf.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.cxf.service.HelloWorld" ,serviceName = "HelloService")
public class HelloWorldImpl implements HelloWorld {
    public String sayHi(String text){
        return "say hi, " + text;
    }
}
