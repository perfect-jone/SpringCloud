package com.atjone.springcloud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.atjone.springcloud.bean.Dept;
import com.atjone.springcloud.service.DeptService;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/add")
	public boolean add(Dept dept) {
		return service.add(dept);
	}
	
	@RequestMapping("/get/{did}")
	public Dept get(@PathVariable("did")Long did) {
		return service.get(did);
	}
	
	@RequestMapping("/list")
	public List<Dept> list() {
		return service.list();
	}
	
	@RequestMapping("/discovery")
	public Object getDiscovery(){
		
		List<ServiceInstance> list = client.getInstances("MICROSERVICEDEPT-DEPT");
		for (ServiceInstance element : list) {
			System.out.println(element.getHost()+" "+element.getPort()+" "+element.getServiceId()+" "+element.getMetadata()+" "+element.getUri());
		}
		return this.client;
		
	}
}
