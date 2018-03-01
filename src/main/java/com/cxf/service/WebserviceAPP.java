package com.cxf.service;

import javax.xml.ws.Endpoint;

public class WebserviceAPP {
    public static void main(String[] args){
        System.out.println("------start service------");
        HelloWorldImpl hwi = new HelloWorldImpl();
        String address = "http://localhost:8080/helloworld";
        Endpoint.publish(address,hwi);
        System.out.println("------end service------");
    }
}
