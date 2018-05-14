<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/pubs.css'/>"></link>
  	<style type="text/css">
  		*{
  			font-size:10pt;
  		}
  		table {
			border:1px solid gray;
			border-collapse:collapse;
			width:60%;
		}
		td{
			border:1px solid gray;
			padding:5px;
		}
  	</style>
  </head>
  <body style="text-align:center;padding-top:30px;">
  	<table>
  		<tr style="background:#AAddaa;">
  			<td colspan="5">
  				以下是你买的所有图书
  			</td>
  		</tr>
  		<tr style="background:#99ddaa;">
  			<td>名称	</td><td>单价</td><td>数量</td>
  			<td>小计</td><td>操作</td>
  		</tr>
  		<c:set value="0" var="sums"></c:set>
  		<c:forEach items="${car}" var="entry">
  			<tr>
  				<td>
  					${entry.value.name}
  				</td>
  				<td>
  					<fmt:formatNumber value="${entry.value.price*entry.value.rebate}" pattern="#.00"/>
  				</td>
  				<td>
  					${entry.value.sum}
  				</td>
  				<td>
  					<fmt:formatNumber var="xj" value="${entry.value.price*entry.value.rebate*entry.value.sum}" pattern="#.00"/>
  					${xj}
  					<c:set value="${sums+xj}" var="sums"></c:set>
  				</td>
  				<td>
  					<a href="#">加</a>
  					&nbsp;
  					<a href="#">减</a>
  					&nbsp;
  					<a href="#">删</a>
  				</td>
  			</tr>
  		</c:forEach>
  		<tr>
  			<td colspan="5">
  				合计：<fmt:formatNumber value="${sums}" pattern="#.00"/>元
  			</td>
  		</tr>
 		<tr>
 			<td colspan="5" align="right">
 				<a href="<c:url value='/secu/OrderServlet'/>">生成订单</a>
 			</td>
 		</tr>
  	</table>
  </body>
</html>
