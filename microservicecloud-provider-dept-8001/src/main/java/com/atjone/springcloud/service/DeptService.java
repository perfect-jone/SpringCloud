package com.atjone.springcloud.service;

import java.util.List;
import com.atjone.springcloud.bean.Dept;


public interface DeptService {
	public boolean add(Dept dept);
	public Dept get(Long did);
	public List<Dept> list();
}
