<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function deletebutton(email){
	alert('click ok to delete' + email)
	document.forms[0].action="${pageContext.request.contextPath}/deleteUser?userform="+email;
	document.forms[0].method="post";
	document.forms[0].submit();
}
</script>
</head>
<body>
${message} 
	<form>
		<table border="1">
			<tr>
				<th>name</th>
				<th>email</th>
				<th>password</th>
				<th>mobile</th>
			</tr>
		
			<c:forEach var="Value" items="${mg}">
			<tr>
			<td>${Value.name}</td>
			<td>${Value.email}</td>
			<td>${Value.password}</td>
			<td>${Value.mobile}</td>
			<td><input type="button" onclick="deletebutton('${Value.email}')" value="delete"/></td>
			</tr>
			</c:forEach>
		</table>
	</form>
	
	click here to <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
	<form action="logout">
	<input type="submit" value="logout">
	</form>
</body>

</html>