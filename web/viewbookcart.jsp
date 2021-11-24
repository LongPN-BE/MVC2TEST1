<%-- 
    Document   : viewbookcart
    Created on : Oct 19, 2021, 11:00:00 AM
    Author     : tunbe
--%>

<%@page import="java.util.Map"%>
<%@page import="longpn.cart.CartObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book store</title>
    </head>
    <body>
        <h1>Your Cart</h1>
        <a href="loginPage">Login</a>
        <c:set var="cart" value="${sessionScope.CART}"/>
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
                                    <a href="shoppingPage">Add more to cart</a>
                                </td>
                                <td>
                                    <input type="submit" value="Remove Book" name="btnAction" />
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
        </c:if>

        <%-- start ol code
<%
            //1. Cust gose to his/her cart place 
            //Có session trong JSP rồi => ko cần viết -> Inselist OBJ

            //vài đối tượng không làm gì có mà coi view giỏ hàng 
            if (session != null) {
                //2 Gust take his/her cart
                CartObject cart = (CartObject) session.getAttribute("CART");
                //Check cart to view
                if (cart != null) {
                    //3. Cust gets all items
                    Map<String, Integer> items = cart.getItems();
                    if (items != null) {
        %>
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
            <form action="DispatcherServlet">
                <%
                    int count = 0;
                    //Dùng key để tìm 
                    for (String title : items.keySet()) {
                %>
                <tr>
                    <td>
                        <%= ++count%>
                    </td>
                    <td>
                        <%= title%>
                    </td>
                    <td>
                        <%= items.get(title)%>
                    </td>
                    <td>
                        <input type="checkbox" name="chkItem" value="<%= title %>" />
                    </td>
                </tr>
                <%
                    }//end for
                %>
                <tr >
                    <td colspan="3">
                        <a href="shopping.html">Add more to cart</a>
                    </td>
                    <td>
                        <input type="submit" value="Remove" name="btnAction" />
                    </td>
                </tr>

            </form>

        </tbody>
    </table>


    <%
                    return;
                }//item had existed
            }//cart had existed
        }//cart place must exist
    %>
    <h2>
        No cart existed!!!
    </h2>
        end old code --%>
    </body>
</html>
