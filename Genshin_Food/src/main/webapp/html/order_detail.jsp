<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/10/2023
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Order detail</title>
    <!--    Bootstrap 5-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body>
<form action="" method="post">
    <h2>Ma DH <c:out value="${requestScope['order'].getIdOrder()}"/></h2>
    <h2>D/c KH <c:out value="${requestScope['order'].getAddressOrder()}"/> </h2>
    <h2>DSSP</h2>
    <table class="table table-hover">
        <tr>
            <th>SP</th>
            <th>Gia</th>
            <th>SL</th>
            <th>TT</th>
        </tr>
        <c:forEach var="item" items="${requestScope['order'].getItemList()}">
            <tr>
                <td><c:out value="${item.getFood().getNameFood()}"/></td>
                <td><c:out value="${item.getFood().getPriceFood()}"/></td>
                <td><c:out value="${item.getQuantity()}"/></td>
                <td><c:out value="${item.getPrice() * item.getQuantity()}"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" class="btn btn-primary" value="Xu ly">
</form>
</body>
</html>
