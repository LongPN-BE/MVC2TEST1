<%-- 
    Document   : shopMobile
    Created on : Oct 31, 2021, 1:08:03 PM
    Author     : tunbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="stylesheet/mobilepage.css">
        <title>Shop Mobile</title>
    </head>
    <body>
        <h1>PAGE SHOP MOBILE</h1>
        <form action="dispatcher">
            Search value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" />
            <input type="submit" value="Search Mobile" name="btnAction" />
        </form>


        <c:set var="list" value="${requestScope.MOBILE_LIST}" />
        <c:if test="${not empty list}">
            <table border="2">
                <thead>  
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Add Items</th>
                    </tr>          
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${list}" varStatus="count">
                    <form action="dispatcher">
                        <tr>
                            <td>${count.count}</td>
                            <td>${dto.mobileID}
                                <input type="hidden" name="txtMobileID" value="${dto.mobileID}" /> 
                            </td>
                            <td>${dto.mobilename}</td>
                            <td>${dto.description}</td>
                            <td>${dto.price}</td>
                            <td>
                                <input type="submit" value="Add Mobile To Cart" name="btnAction" />
                                <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}" />
                            </td> 
                        </tr>
                    </form>                    
                </c:forEach>
                <tr>
                    <td colspan="5">
                    </td>
                    <td colspan="1">
                        <a href="viewCartMobilePage">View cart</a>
                    </td>
                </tr>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty list}">
        No items in Shop!!
    </c:if>
</body>
</html>
