package com.atjone.springcloud.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.atjone.springcloud.bean.Dept;
import feign.hystrix.FallbackFactory;

@Component//千万不要忘记添加，不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(Long did) {
				return new Dept().setDid(did).setDname("该id："+did+"没有对应的信息,null--@HystrixCommand").
						setDb_source("no this database in MySQL");
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}
