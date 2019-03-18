package com.atjone.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.atjone.springcloud.bean.Dept;
@FeignClient(value="MICROSERVICECLOUD-DEPT")
public interface DeptClientService {
	@RequestMapping("/dept/add")
	public boolean add(Dept dept);
	
	@RequestMapping("/dept/get/{did}")
	public Dept get(@PathVariable("did")Long did);
	
	@RequestMapping("/dept/list")
	public List<Dept> list();
}
