package com.atjone.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import com.atjone.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
/**
 * 自定义配置类不能放在@ComponentScan注解所在的当前包以及子包下，
 * @SpringBootApplication注解中就有@ComponentScan注解,因此需要
 * 重新建一个包，在新建的包下写MySelfRule类
 *
 * 在启动微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
 */
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
