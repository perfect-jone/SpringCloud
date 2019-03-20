package com.atjone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//eureka服务器启动类，接受其他微服务注册进来
public class Config_Git_EurekaServer7001_App {
	public static void main(String[] args) {
		SpringApplication.run(Config_Git_EurekaServer7001_App.class, args);
	}
}