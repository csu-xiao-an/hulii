package com.emp.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.dao.EmpLazyDao;
import com.emp.entity.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class EmpLazyDaoTest {

	@Resource
	private EmpLazyDao empLazyDao;

	@Test // 依据编号懒加载查询
	public void testLazy() {
		Emp e = empLazyDao.queryById("e002");
		System.out.println(e.getEname() + "," + e.getDept().getDname() + "," + e.getMgr().getEname());
	}

	@Test // 懒加载查询所有员工
	public void testLazy2() {
		List<Emp> emps = empLazyDao.queryAll();
		for (Emp e : emps) {
			System.out.println(e.getEname() + "," + e.getDept().getDname() + "," + e.getMgr().getEname());
		}
	}

	@Test // 懒加载模糊查询员工
	public void testLazy3() {
		List<Emp> emps = empLazyDao.queryLikeName("李");
		for (Emp e : emps) {
			System.out.println(e.getEname() + "," + e.getDept().getDname());
		}
	}

	@Test // 依据部门编号查询部门下所有的员工
	public void testLazy4() {
		List<Emp> emps = empLazyDao.queryEmpByDeptno("d001");
		for (Emp e : emps) {
			System.out.println(e.getEname() + "," + e.getDept().getDname() + "," + e.getDept().getLocation());
		}
	}
	
	@Test // 查询出所有的经理
	public void testLazy5() {
		List<Emp> emps = empLazyDao.queryMgrs();
		for (Emp e : emps) {
			System.out.println(e);
		}
	}
}
