package com.atjone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//先启动服务端，再启动客户端
@EnableDiscoveryClient
public class Config_Git_DeptProvider8001_APP {
	public static void main(String[] args) {
		SpringApplication.run(Config_Git_DeptProvider8001_APP.class, args);
	}
}
