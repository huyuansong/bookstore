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
		.img{
			border:0px solid gray;
			width:160px;
			height:200px;
		}
  	</style>
  </head>
  <body style="margin-top:0px;">
  		<table style="width:100%;" border="0">
  			<tr>
  				<td style="width:180px;">
  					<img class="img" src="<c:url value='/images/${book.img}'/>"></img>
  				</td>
  				<td valign="bottom">
  					书名:${book.name}<br/>
  					价格:${book.price*book.rebate}<br/>
  					作者:${book.auth}<br/>
  					出版:${book.publisher}<br/>
  					<br/>
  					<a href="<c:url value='/secu/BuyServlet?bookid=${book.id}'/>">
  						<img src="<c:url value='/images/btn_buy.gif'/>"></img>
  					</a>
  				</td>
  			</tr>
  			<tr style="background:#F1E1FF;">
  				<td colspan="2">
  					${book.brief}
  				</td>
  			</tr>
  			<tr style="background:#CEFFCE;">
  				<td colspan="2">
  					${book.content}
  				</td>
  			</tr>
  		</table>
  </body>
</html>
