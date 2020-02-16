<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<font color="red">
${msg}
</font>
<body>
${loged}

<form action="add">
add your items:<input type="submit" value="add item"></br></br> 
</form>
<form action="menu">
go to menu:<input type="submit" value="menu">
</form>
<form action="userList">
edit users:<input type="submit" value="user list">
</form>
</body>
</html>