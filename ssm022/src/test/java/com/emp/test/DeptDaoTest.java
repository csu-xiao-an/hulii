package com.emp.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.DeptDao;
import com.emp.entity.Dept;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class DeptDaoTest {
	@Resource
	private DeptDao deptDao;

	@Test // 查询所有部门
	public void testQueryAll() {
		List<Dept> dept = deptDao.queryAll();
		for (Dept d : dept) {
			System.out.println(d);
		}
	}

	@Test // 根据编号查询部门信息
	public void testQueryById() {
		Dept dept = deptDao.queryById("d005");
		System.out.println(dept);
	}

	@Test // 增加部门
	public void testAddDept() {
		Dept dept = new Dept();
		dept.setDeptno("d005");
		dept.setDname("养老部");
		dept.setLocation("阎罗殿");
		deptDao.addDept(dept);
		System.out.println("OK");
	}

	@Test // 删除部门
	public void testDeleteDept() {
		deptDao.deleteDept("d005");
		System.out.println("OK");
	}

	@Test // 依据编号修改部门信息
	public void testUpdateDept() {
		Dept dept = deptDao.queryById("d005");
		dept.setDname("研发部");
		dept.setLocation("日本");
		deptDao.updateDept(dept);
		System.out.println("OK");
	}
}
