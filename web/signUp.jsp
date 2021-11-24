<%-- 
    Document   : signUp
    Created on : Oct 27, 2021, 11:16:21 PM
    Author     : tunbe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New account</h1>
        <form action="dispatcher">
            <c:set var="errors" value="${requestScope.SIGNUPERRS}" />
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" /> (e.g. 6 - 30 chars) <br/>
            <c:if test="${not empty errors.usernameLengViolent}">
                <font color="red">
                ${errors.usernameLengViolent}
                </font></br>
            </c:if>
            Password* <input type="text" name="txtPassword" value="${param.txtPassword}" />  (e.g. 6 - 20 chars) <br/>
            <c:if test="${not empty errors.passwordLengViolent}">
                <font color="red">
                ${errors.passwordLengViolent}
                </font></br>
            </c:if>
            Confirm* <input type="text" name="txtConfirm" value="${param.txtConfirm}" /> <br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                ${errors.confirmNotMatch}
                </font></br>
            </c:if>
            Full name* <input type="text" name="txtFullname" value="${param.txtFullname}" /> (e.g. 2 - 50 chars)<br/>
            <c:if test="${not empty errors.fullnameLengViolent}">
                <font color="red">
                ${errors.fullnameLengViolent}
                </font></br>
            </c:if>
            <input type="submit" value="Sign Up" name="btnAction" />
        </form>
        <c:if test="${not empty errors.usernameIsExisted}">
            <font color="red">
            ${errors.usernameIsExisted}
            </font></br>
        </c:if>  

    </body>
</html>
