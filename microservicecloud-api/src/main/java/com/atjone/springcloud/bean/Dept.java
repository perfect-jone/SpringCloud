package com.atjone.springcloud.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)//代码的链式写法
public class Dept implements Serializable {

	//lombok
	private long did;
	private String dname;
	private String db_source;//数据库来源
}
