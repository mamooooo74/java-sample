<%@page import="sample.model.Person"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>email</th>
				<th>password</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${persons }">
				<tr>
					<td><c:out value="${person.id}"></c:out></td>
					<td><c:out value="${person.name}"></c:out></td>
					<td><c:out value="${person.email}"></c:out></td>
					<td><c:out value="${person.password}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>