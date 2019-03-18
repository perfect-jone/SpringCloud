package com.atjone.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atjone.springcloud.bean.Dept;
import com.atjone.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService service;
	
	//一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod="processHystrix_Get")
	@RequestMapping("/get/{did}")
	public Dept get(@PathVariable("did")Long did) {
		Dept dept = service.get(did);
		if(dept==null){
			throw new RuntimeException("该id："+did+"没有对应的信息");
		}
		return dept;
	}
	
	public Dept processHystrix_Get(@PathVariable("did")Long did){
		return new Dept().setDid(did).setDname("该id："+did+"没有对应的信息,null--@HystrixCommand").
				setDb_source("no this database in MySQL");
		
	}
	
}
