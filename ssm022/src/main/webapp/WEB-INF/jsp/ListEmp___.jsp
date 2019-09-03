<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 600px;
	border: 3px solid #ccc;
	border-collapse: collapse;
	margin: auto;
	margin-top: 20px;
}

table th, table td {
	border: 1px solid #ccc;
}

span{
   width: 20px;
   height: 20px;
   display: inline-block;
   border: 1px solid #ff6633;
   margin-left: 5px;
}
span a{
   width: 20px;
   height: 20px;
   display: inline-block;
   text-decoration: none;
   font-size: 12px;
   text-align: center;
   line-height: 20px;
}
.on{
  background: #ccc;
  font-size: 14px;
  font-weight: 900;
}

</style>
</head>
<body>
	<h1 align="center">员工列表</h1>
	<h3 align="center">
		<a href="#">添加员工</a>
	</h3>
	
	<!-- 在页面渲染数据到table中  -->
	<table>
		<tr>
			<!-- <th>编码</th> -->
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>薪资</th>
			<th>部门</th>
			<th>经理</th>
			<th>操作</th>
		</tr>
		<c:forEach var="emp" items="${pageBean.list}">
			<tr>
				<%-- <td>${emp.empno}</td> --%>
				<td>${emp.ename}</td>
				<td>${emp.esex}</td>
				<td>${emp.eage}</td>
				<td>${emp.esalary}</td>
				<td>${emp.dept.dname}</td>
				<td>${emp.mgr.ename}</td>
				<th>
				    <a href="#">删除</a>
					<a href="#">修改</a>
			    </th>
			</tr>
		</c:forEach>
	</table>
	<P align="center">
	   <a href="javascript:changePage(${pageBean.first});"><input type="button" value="首页"></a>
		<a href="javascript:changePage(${pageBean.previous});"><input type="button" value="上一页"></a>
		<c:forEach begin="1" end="${pageBean.last}" var="no">
			<c:if test="${pageBean.pageNo==no}">
				<span class="on"> <a href="javascript:changePage(${no});"> ${no} </a>
				</span>
			</c:if>
			<c:if test="${pageBean.pageNo!=no}">
				<span> <a href="javascript:changePage(${no});"> ${no} </a>
				</span>
			</c:if>
		</c:forEach>
		<a href="javascript:changePage(${pageBean.next});"><input type="button" value="下一页"></a>
		<a href="javascript:changePage(${pageBean.last});"><input type="button" value="尾页"></a>
	</P>
	
<script type="text/javascript">
    function changePage(no){
    	location.href="${pageContext.request.contextPath}/emp/list?pageNo="+no;
    }
</script>
</body>
</html>