<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function editbutton(itemid) {
	alert('click ok to edit' + itemid)
	document.forms[0].action="${pageContext.request.contextPath}/editItem?editform="+itemid;
	document.forms[0].method="post";
	document.forms[0].submit();
}
function deletebutton(itemid){
	alert('click ok to delete' + itemid)
	document.forms[0].action="${pageContext.request.contextPath}/deleteItem?itemform="+itemid;
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
				<th>itemid</th>
				<th>itemName</th>
				<th>price</th>
				<th>quantity</th>
				<th>Veg/nonVeg</th>
			</tr>

			<c:forEach var="Value" items="${msg}">
				<tr>
					<td>${Value.itemid}</td>
					<td>${Value.itemName}</td>
					<td>${Value.price}</td>
					<td>${Value.quant}</td>
					<td>${Value.selected}</td>
					<td><input type="button" onclick="editbutton(${Value.itemid})" value="edit"></td>
					<td><input type="button" onclick="deletebutton(${Value.itemid})" value="delete"></td>
					
				</tr>
			</c:forEach>

		</table>

	</form>

click here to <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</body>

</html>