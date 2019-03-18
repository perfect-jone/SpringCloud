package com.atjone.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
@Configuration
public class ConfigBean {
	
	//ConfigBean(@Configuration)=applicationContext.xml
	//<bean id="userservice" class="com.atjone.springcloud.UserServiceImpl"
	@Bean
	@LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端   负载均衡的工具
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	@Bean
	public IRule myRule(){
		//return new RandomRule();//用重新选择的随机算法替代默认的RoundRibonRule轮询算法
		return new RetryRule();//如果服务提供者没有宕机，则默认轮询算法；如果其中有一个宕机，则经过一段时间的尝试之后跳过该宕机的服务
	}
}
