package com.atjone.springcloud.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.atjone.springcloud.bean.Dept;
@Mapper
public interface DeptDao {
	public Dept get(Long did);
	public List<Dept> list();
	public boolean add(Dept dept);
}
