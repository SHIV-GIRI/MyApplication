<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Department</title>


</head>
<body background="dataset.jpg">
	<h2 style="color: orange;">Add Department</h2>
	<sf:form method="post" modelAttribute="dept" style="color: yellow;">
Id:<sf:input style="color: green;"
			path="id" />
Name:<sf:input style="color: green;"
			path="name" />
		<input style="color: green;" type="Submit" value="Add dept" />
	</sf:form>

	<h4>${message }</h4>
</body>
</html>