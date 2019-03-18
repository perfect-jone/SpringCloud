package com.atjone.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atjone.springcloud.bean.Dept;
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {
	/**
	 * 使用restTemplate访问restful接口时，（url,requestMap,responseBean.class）
	 * 这三个参数分别代表rest请求地址，请求参数，HTTP响应转换被装换成的对象类型
	 */
	//private static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";//改为微服务名

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	@RequestMapping("/get/{did}")
	public Dept get(@PathVariable("did") Long did){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+did, Dept.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
		
	}
	
	@RequestMapping("/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
		
	}
	
	
}
