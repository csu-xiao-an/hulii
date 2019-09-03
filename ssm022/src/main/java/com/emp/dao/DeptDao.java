package com.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emp.entity.Dept;

public interface DeptDao {
	// 查询所有部门
	@Select(" select deptno,dname,location from t_dept ")
	@Results(id = "deptMapper", value = { 
			@Result(id = true, column = "deptno", property = "deptno"),
			@Result(column = "dname", property = "dname"), 
			@Result(column = "location", property = "location") 
			})
	public List<Dept> queryAll();

	// 根据编号查询部门信息
	@Select("select deptno,dname,location from t_dept where deptno=#{deptno}")
	@ResultMap(value = "deptMapper")
	public Dept queryById(@Param("deptno")String deptno);

	// 增加部门
	@Insert(" insert into t_dept values(#{deptno},#{dname},#{location}) ")
	public void addDept(Dept dept);

	// 根据编号删除部门
	@Delete(" delete from t_dept where deptno=#{deptno} ")
	public void deleteDept(@Param("deptno") String deptno);

	// 依据编号修改部门信息
	@Update(" update t_dept set dname=#{dname},location=#{location} where deptno=#{deptno}")
	public void updateDept(Dept dept);
}
