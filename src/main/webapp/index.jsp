<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ include file="requireConfig.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>requirejs入门（一）</title>
		<script src="js/note/main.js"></script>
	</head>
	<body>

	 <div id="test1">
	<script type="text/template" id="list">
     show list:
	<div>
	{{#users}}
     username:{{username}}</br>
    {{/users}}
	</div>
	 </script>
	 </div>
	  <input id="button" type="button" value="button" >
	</body>
</html>
