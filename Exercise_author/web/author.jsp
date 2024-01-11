<%-- 
    Document   : author
    Created on : Jan 11, 2024, 9:24:21 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>choose an author: </h3>
        <form method="get">
            <input type="checkbox" name="author" value="Tan Ah Teck"/>Tan
            <input type="checkbox" name="author" value="Mohd Ali"/>Ali
            <input type="checkbox" name="author" value="Kumar"/>Tan
            <input type="submit" value="Query"/>
        </form>
        
        <% String[] authors = request.getParameterValues("author");
        if(authors != null){
        %>
        <h3>You have select author(s):</h3>
        <ul>
            <%
                for(int i = 0; i< authors.length; i++){
                    %>
                    <li><%= authors[i]%></li>
                    <%
                }
            %>
                 
        </ul>
            <a href="<%= request.getRequestURI()%>">BACK</a>
            <%
        }%>
    </body>
</html>
