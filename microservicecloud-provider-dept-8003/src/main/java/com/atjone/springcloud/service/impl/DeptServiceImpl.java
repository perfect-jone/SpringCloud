package com.atjone.springcloud.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atjone.springcloud.bean.Dept;
import com.atjone.springcloud.dao.DeptDao;
import com.atjone.springcloud.service.DeptService;
@Service
@Transactional
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptDao dao;

	@Override
	public boolean add(Dept dept) {
		return dao.add(dept);
	}

	@Override
	public Dept get(Long did) {
		return dao.get(did);
	}

	@Override
	public List<Dept> list() {
		return dao.list();
	}
	
}
