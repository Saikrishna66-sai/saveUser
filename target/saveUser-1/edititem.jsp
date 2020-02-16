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
<form action="edited">
<input type ="hidden" name="version" value="${edititem.version}">
item Id:<input type="text" name="itemid" value="${edititem.itemid}"></br>
veg:<input type="radio" name="selected" value="veg"></br>
non veg:<input type="radio" name="selected" value="non veg"></br>
item Name:<input type="text" name="itemName" value="${edititem.itemName}"></br>
quantity:<input type="text" name="quant" value="${edititem.quant}"></br>
price:<input type="text" name="price" value="${edititem.price}"></br>
<input type="submit" value="add items">
</form>
click here to <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</body>
</html>