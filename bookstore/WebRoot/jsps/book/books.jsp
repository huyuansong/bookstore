<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  		div {
			border:1px solid gray;
			width:160px;
			height:200px;
			text-align:center;
			float: left;
			margin:3px;
		}
		img{
			border:0px solid gray;
			width:160px;
			height:200px;
		}
  	</style>
  </head>
  <body style="margin-top:0px;">
  		以下是所有图书<br/>
		<c:forEach items="${list}" var="book">
			<div>
			<a href="<c:url value='/BookServlet?cmd=detail&bookid=${book.id}'/>">
				<img src="<c:url value='/images/${book.img}'/>">
			</a>
			<br/>
			${book.name}
			<c:choose>
				<c:when test="${book.rebate==1}">
					${book.price}
				</c:when>
				<c:otherwise>
					<font style="text-decoration: line-through;">
					${book.price}
					</font>
					&nbsp;
					<fmt:formatNumber value="${book.price*book.rebate}" pattern="#,###.00"/>
				</c:otherwise>
			</c:choose>
			元
			</div>
		</c:forEach>
  </body>
</html>
