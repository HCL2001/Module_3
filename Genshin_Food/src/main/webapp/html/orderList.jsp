<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/10/2023
  Time: 7:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Food List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <%--  Favicon--%>
    <link rel="shortcut icon" href="https://th.bing.com/th/id/OIP.f9P3mL2hwGb18tPEi0SA8wHaHa?pid=ImgDet&rs=1"
          type="image/x-icon">
</head>
<body>
<h1 style="text-align: center">Order Management</h1>
<h2 style="text-align: center">
    <a href="foods?action"><input type="button" value="Back to main page" class="btn btn-info"></a>
</h2>

<div class="container-xxl pt-5" align="center">
    <table class="table table-hover">
        <h2>List of Oder</h2>
        <tr>
            <th>IdOrder</th>
            <th>DateOrder</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Total</th>
            <th>Status</th>
        </tr>
        <c:forEach var="order" items="${requestScope['listOrder']}">
            <tr>
                <td><c:out value="${order.getIdOrder()}"/></td>
                <td><c:out value="${order.getDateOrder()}"/></td>
                <td><c:out value="${order.getAddressOrder()}"/></td>
                <td><c:out value="${order.getPhoneNumber()}"/></td>
                <td><c:out value="${order.getTotal()}"/></td>
                <td><c:out value="${order.isStatus()}"/></td>
                <td>
                    <a href="foods?action=orderDetail&idOrder=${order.getIdOrder()}">Detail</a>
                    <a href="">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
