package com.atjone.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atjone.springcloud.bean.Dept;
import com.atjone.springcloud.service.DeptClientService;
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {
	
	@Autowired
	private DeptClientService service;
	
	
	@RequestMapping("/add")
	public boolean add(Dept dept){
		return service.add(dept);
	}
	
	@RequestMapping("/get/{did}")
	public Dept get(@PathVariable("did") Long did){
		return service.get(did);
	}
	
	@RequestMapping("/list")
	public List<Dept> list(){
		return service.list();
	}
	
	
	
	
}
