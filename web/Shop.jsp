<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  
  <head>
    <title>JSP Shop</title>
    </head>
  
  <body>
    <h1>JSP butik</h1>
    <hr/>
    <table>
      <tr>
	<th>#</th>
	<th>Navn</th>
	<th>Beløb</th>
	</tr>
    <c:forEach var="item" items="${basket.items}">
      <tr>
	<td>${item.id}</td>
	<td>${item.name}</td>
	<td>${item.price}</td>
        </tr>
      </c:forEach>
      </table>
    </body>

  </html>
