<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">
${msg}</br></br>
${msg2}
</font>
<font color="blue"><h4>login</h4></font>
<form action="<c:url value='/j_spring_security_check'/>" method="post">
email:<input type="text" name="email"></br></br>
password:<input type="password" name="password"></br></br>
<input type="submit" value="login">

<a href="register.jsp">click here</a>to register</br></br>
<a href="item.jsp">click here</a>for item list
</form>
</body>
</html>