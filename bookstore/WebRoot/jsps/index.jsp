<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<style type="text/css">
  		*{
  			font-size:10pt;
  		}
  		table {
			border:1px solid gray;
			border-collapse:collapse;
			width:1024px;
			height:120%;
		}
		td{
			border:1px solid gray;
		}
  	</style>
  </head>
  <body style="text-align:center;margin-top:0px;">
  	<table>
  		<tr style="background:#ffddaa;">
  			<td colspan="2" height="80" style="padding-right:10px;">
  				图书网。。。。
  				<div style="float: right">
  				<c:choose>
  					<c:when test="${empty sessionScope.user}">
  						<a target="dataFrame" href="<c:url value='/jsps/user/login.jsp'/>">登录</a>
  						|
  						<a target="dataFrame" href="<c:url value='/jsps/user/reg.jsp'/>">注册</a>
  					</c:when>
  					<c:otherwise>
  						欢迎你：<a href="">${user.name}</a>
  						|
  						<a href="#">订单</a>
  						|
  						<a target="dataFrame" href="<c:url value='/jsps/buy/car.jsp'/>">购物车</a>
  						|
  						<a href="#">退出</a>
  					</c:otherwise>
  				</c:choose>
  				
  				</div>
  			</td>
  		</tr>
  		<tr>
  			<td align="center" valign="top" style="width:120px;">
  				<a  target="dataFrame" href="<c:url value='/BookServlet'/>">全部</a><br/>
  				<c:forEach items="${types}" var="t">
  					<a target="dataFrame" href="<c:url value='/BookServlet?typeid=${t.id}'/>">${t.name}</a><br/>
  				</c:forEach>
  			</td>
  			<td>
  				<c:url value="/BookServlet" var="url"></c:url>
  				<!-- 是否在sessin中存在bookid -->
  				<c:if test="${not empty sessionScope.bookid}">
  					<c:url value="/BookServlet?cmd=detail&bookid=${bookid}" var="url"/>
  					<c:remove var="bookid" scope="session"/>
  				</c:if>
  				<iframe name="dataFrame" src="${url}" frameborder="0" width="100%" height="100%"></iframe>
  			</td>
  		</tr>
  	</table>
  </body>
</html>
