<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>
</head>
<body background="udate2.jpg">
	<h4 style="color: green;">Edit Department</h4>
	<c:if test="${dept !=null}">

		<sf:form method="post" modelAttribute="dept" style="color: orange;">
Id:<sf:input path="id" />
Name:<sf:input path="name" />
			<input type="Submit" value="update" />
		</sf:form>
	</c:if>
	<h4 style="color: red;">${error}</h4>

</body>
</html>