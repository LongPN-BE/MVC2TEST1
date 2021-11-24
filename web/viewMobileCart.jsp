<%-- 
    Document   : viewMobileCart
    Created on : Nov 1, 2021, 4:40:17 PM
    Author     : tunbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet/mobilepage.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your Mobile Cart</h1>
        <a href="loginPage">Login Page</a>
        <c:set var="cart" value="${sessionScope.CARTMOBILE}"/>
        <c:if test="${not empty cart}">
            <c:set var="items" value="${cart.items}"/>
            <c:if test="${not empty items}">
                <form action="dispatcher">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No.</th>
                                <th>Title</th>
                                <th>Quantity</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${items}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${item.key}</td>
                                    <td>${item.value}</td>
                                    <td>
                                        <input type="checkbox" name="chkItem" value="${item.key}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="3">
                                    <a href="searchMobileControl?txtSearchValue=null">Add more to cart</a>
                                </td>
                                <td>
                                    <input type="submit" value="Remove Mobile From Cart" name="btnAction" />
                                </td>

                            </tr>
                            <tr>
                                <td colspan="4">
                                    <input type="submit" value="Check Out" name="btnAction" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>          
            </c:if>
        </c:if>
        <c:if test="${empty cart}">
            <h2>
                No Cart is Existed!!
            </h2>
            <a href="searchMobileControl?txtSearchValue=null">Add more to cart</a>
        </c:if>
    </body>
</html>
