package com.atjone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul9527_APP {
	public static void main(String[] args) {
		SpringApplication.run(Zuul9527_APP.class, args);
	}
}
