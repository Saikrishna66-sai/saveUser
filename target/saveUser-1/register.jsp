<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>registration</h4>
<h4>${msg}</h4>
<form action="new">
name<input type="text" name="name"></br></br>
email<input type="text" name="email"></br></br>
password<input type="password" name="password"></br></br>
mobile<input type="text" name="mobile"></br></br>
<input type="submit" value="register"></br></br>
already have an account click here to<a href="login.jsp">login</a>
</form>
</br></br></br>
<form action="heep">
<input type="submit" value="treat">
</form>
</body>
</html>