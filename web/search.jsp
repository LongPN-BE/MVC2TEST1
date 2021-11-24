<%-- 
    Document   : search
    Created on : Oct 5, 2021, 11:09:42 AM
    Author     : tunbe
--%>

<%@page import="longpn.registration.RegistrationDAO"%>
<%@page import="longpn.registration.RegistrationDTO"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search PAGE</title>
    </head>
    <body>
        <%--start old code
      <%
          Cookie[] cookies = request.getCookies();
          if (cookies != null) {
              Cookie lastCookie = cookies[cookies.length - 1];
              if(lastCookie.getName().equals("JSESSIONID")){
                  lastCookie = cookies[cookies.length - 2];
              }
      %>
      
      
      <font color="red">
      Welcome, <%= lastCookie.getName() %>
      </font>
      <%
         }
      %>
      end old code--%>

        <font color="red"> Hello, ${sessionScope.USER}    </font>  
        <h1>SEARCH PAGE</h1>
        <form action="dispatcher">
            Input search <input type="text" value="${param.txtSearch}"  name="txtSearch"> 
            <input type="submit" value="Search" name="btnAction">
            <input type="submit" value="Log out" name="btnAction"/>
        </form>

        <c:set var="searchValue" value="${param.txtSearch}" />
        <c:if test="${not empty searchValue}" >
            <c:set var="result" value="${requestScope.SEARCH_RESULT}" />
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Full name</th>
                            <th>Role</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                        <form action="dispatcher">
                            <tr>
                                <td>${counter.count}</td>
                                <td>
                                    ${dto.username}
                                    <input type="hidden" name="txtUsername" value="${dto.username}" />
                                </td>
                                <td>
                                    <input type="text" name="txtPassword" value="${dto.password}" />
                                </td>
                                <td>
                                    <input type="text" name="txtLastname" value="${dto.lastname}" />
                                </td>
                                <td>
                                    <input type="checkbox" name="chkAdmin" value="ON" 
                                           <c:if test="${dto.role}">
                                               checked="checked"
                                           </c:if>
                                           />
                                </td>
                                <td>
                                    <c:url var="urlRewriting" value="deleteControl">
                                        <c:param name="pk" value="${dto.username}"/>
                                        <c:param name="lastSearchValue" value="${param.txtSearch}"/>
                                    </c:url>
                                    <a href="${urlRewriting}">Delete</a>
                                </td>
                                <td>
                                    <input type="submit" value="Update" name="btnAction" />
                                    <input type="hidden" value="${param.txtSearch}"  name="txtSearch"> 
                                </td>
                            </tr>
                        </form>              
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty result}">
            <h2>
                No record is matched!!
            </h2>
        </c:if>
    </c:if>




    <%--start old code
    <%
        String searchValue = request.getParameter("txtSearch");
        if (searchValue != null) {

                List<RegistrationDTO> result = (List<RegistrationDTO>) request.getAttribute("SEARCH_RESULT");
                if (result != null) {
        %>
        <table border = "1">
            <thead>
            <th>NO.</th>
            <th>Username</th>
            <th>Password</th>
            <th>Full name</th>
            <th>Role</th>
            <th>Delete</th>
            <th>Update</th>
        </thead>
        <tbody>
            <%
                int count = 0;
                for (RegistrationDTO dto : result) {
                    String urlRewriting = "DispatcherServlet"
                            + "?btnAction=Delete"
                            + "&pk=" + dto.getUsername()
                            + "&lastSearchValue=" + searchValue;
            %>
        <form action="DispatcherServlet">

            <tr>
                <td><%= ++count%></td>
                <td><%= dto.getUsername()%>
                    <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>"/>
                </td>
                <td>
                    <input type="text" name="txtPassword" value="<%= dto.getPassword()%>" />                    
                </td>
                <td>
                    <input type="text" name="txtLastname" value="<%= dto.getLastname()%>" />                   
                </td>
                <td>
                    <input type="checkbox" name="chkAdmin" value="ON"
                           <%
                               if (dto.isRole()) {
                           %>checked="checked"<%
                               }
                           %>
                           />
                <td> 
                    <a href="<%= urlRewriting%>">Delete</a>
                </td>
                <td> 
                    <input type="submit" value="Update" name="btnAction"/>
                    <input type="hidden" name="lastSearchValue"
                           value="<%=searchValue%>"/>
                </td>
            </tr>
        </form>
        <%
            }//end
        %>
    </tbody>
</table>
<%
} else {
%>
No record is matched!!
<%
        }
    }
%>
 //end ole code --%>
</body>
</html>
