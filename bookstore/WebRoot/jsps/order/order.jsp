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
		}
  	</style>
  </head>
  <body style="margin:20px;">
  	<table>
  		<tr style="background:#AAddaa;">
  			<td colspan="4">
  				请选择收货人地址
  			</td>
  		</tr>
  		<tr style="background:#99ddaa;">
  			 <td>
  			 	选择
  			 </td>
  			 <td>姓名</td><td>地址</td><td>电话</td>
  		</tr>
  		<c:forEach items="${address}" var="addr">
  			<tr>
  			 <td>
  			 	<input type="radio" onclick="_chk(this);" value="${addr.id}" name="id">
  			 </td>
  			 <td>
  			 	${addr.name}
  			 </td><td>${addr.addr}</td><td>${addr.tel}</td>
  			</tr>
  		</c:forEach>
  		
  	</table>
  	<hr/>
  	<p>收货方式：</p>
  		<select name="paytype">
			<option value="1">货到付款</option>
			<option value="2">在线支付</option>
  		</select>
  	<hr/>
  		<table>
  		<tr style="background:#AAddaa;">
  			<td colspan="4">
  				以下是你买的所有图书
  			</td>
  		</tr>
  		<tr style="background:#99ddaa;">
  			<td>名称	</td><td>单价</td><td>数量</td>
  			<td>小计</td>
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
  			</tr>
  		</c:forEach>
  		<tr>
  			<td colspan="4">
  				合计：<fmt:formatNumber value="${sums}" pattern="#.00"/>元
  			</td>
  		</tr>
 		<tr>
 			<td colspan="4" align="right">
 				<form name="x" action="<c:url value='/secu/OrderServlet?cmd=create'/>" method="post">
 					<input id="addr" type="text" name="addr">
 					<img onclick="_create();" src="<c:url value='/css/imgs/a.bmp'/>"></img>
 				</form>
 			</td>
 		</tr>
  	</table>
  </body>
  <script type="text/javascript">
  	function _chk(obj){
  		if(obj.checked==true){
			document.getElementById("addr").value=obj.value; 			
  		}
  	}
  	function _create(){
  		document.forms['x'].submit();
  	}
  </script>
</html>
