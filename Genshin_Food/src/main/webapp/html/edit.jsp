<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/7/2023
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Food Management Application</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container-xxl pt-5">
    <h1>Food Management</h1>
    <h2>
        <a href="foods?action=admin">List Food</a>
    </h2>
</div>
<div class="container-xxl pt-5">
    <form method="post">
        <table class="table table-hover">
            <h2>Update Food</h2>
            <tr>
                <th>Food Id:</th>
                <td>
                    <input type="text" name="idNewFood" id="idNewFood" size="45" value="<c:out value="${food.getIdFood()}"/>">
                </td>
            </tr>
            <tr>
                <th>Food Name</th>
                <td>
                    <input type="text" name="foodName" id="foodName" size="45"
                           value="<c:out value="${food.getNameFood()}"/>">
                </td>
            </tr>
            <tr>
                <th>Food description</th>
                <td>
                    <input type="text" name="descriptionFood" id="descriptionFood" size="100"
                           value="<c:out value="${food.getDescriptionFood()}"/>">
                </td>
            </tr>
            <tr>
                <th>Food price</th>
                <td>
                    <input type="text" name="priceFood" id="priceFood" size="100"
                           value="<c:out value="${food.getPriceFood()}"/>">
                </td>
            </tr>
            <tr>
                <th>Food Country</th>
                <td>
                    <input type="text" name="countryFood" id="countryFood" size="15"
                           value="<c:out value="${food.getCountryFood()}"/>">
                </td>
            </tr>
            <tr>
                <th>Food IMG</th>
                <td>
                    <input type="text" name="imgFood" id="imgFood" size="100"
                           value="<c:out value="${food.getImgFood()}"/>">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
