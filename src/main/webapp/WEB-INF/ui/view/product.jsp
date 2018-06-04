<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/product/addProduct" method="GET" modelAttribute="product">
 			description <input type="text" name="description"></br>
 			imageUrl <input type="text" name="imageUrl"></br>
 			productName <input type="text" name="productName"></br>
 			productPrice <input type="text" name="productPrice"></br>
 			
 			<input type="submit" value="Add" /> 
     </form:form>
     <table>
			<tr>
				<th>Item Name</th>
				<th>Item Price</th>
				<th>Description</th>
			</tr>
			 <c:forEach items="${products}" var="pro" >
			<tr>
				<%-- <td><c:out value="${pro.productId }"/></td> --%>
				<td><c:out value="${pro.productName }"/></td>
				<td><c:out value="${pro.productPrice }"/></td>
				<td><c:out value="${pro.description}"/></td>
				<td><a href="<c:url value='/product/delete/${pro.productId}' />" >Delete</a></td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>