package com.cxf.client;

import com.cxf.service.HelloWorld;
import com.cxf.weather.ArrayOfString;
import com.cxf.weather.WeatherWS;
import com.cxf.weather.WeatherWSSoap;
/*import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class HelloWorldClient {
    /*public static void main(String[] args){
        System.out.println("++++++start webservice++++++");
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        HelloWorld client = (HelloWorld) factory.getBean("client");
        String result = client.sayHi("hello spring!");
        System.out.println(result);
    }*/

    /*public  static void main(String[] args){
        JaxWsProxyFactoryBean factory2 = new JaxWsProxyFactoryBean();
        factory2.getInInterceptors().add(new LoggingInInterceptor());
        factory2.getOutInterceptors().add(new LoggingOutInterceptor());
        factory2.setServiceClass(HelloWorld.class);
        factory2.setAddress("http://localhost:8080/helloworld");
        HelloWorld client2 = (HelloWorld) factory2.create();
        String reply = client2.sayHi("hello world!");
        System.out.println(reply);
    }*/

    /*public  static void main(String[] args){
        JaxWsProxyFactoryBean factory2 = new JaxWsProxyFactoryBean();
        factory2.getInInterceptors().add(new LoggingInInterceptor());
        factory2.getOutInterceptors().add(new LoggingOutInterceptor());
        factory2.setServiceClass(WeatherWSHttpPost.class);
        factory2.setAddress("http://www.webxml.com.cn/WebServices/WeatherWS.asmx");
        WeatherWSHttpPost client2 = (WeatherWSHttpPost) factory2.create();
        String reply = client2.getRegionCountry();
        System.out.println(reply);
    }*/

    public static void main(String[] args) {
        //创建一个WeatherWS工厂
        WeatherWS factory = new WeatherWS();
        //根据工厂创建一个WeatherWSSoap对象
        WeatherWSSoap weatherWSSoap = factory.getWeatherWSSoap();
        //调用WebService提供的getWeather方法获取深圳市的天气预报情况
        ArrayOfString weatherInfo = weatherWSSoap.getWeather("深圳", null);
        List<String> listWeatherInfo = weatherInfo.getString();
        //遍历天气预报信息
        for (String string : listWeatherInfo) {
            System.out.println(string);
            System.out.println("------------------------");
        }
    }
}
