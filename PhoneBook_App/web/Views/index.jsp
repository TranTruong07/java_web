<%-- 
    Document   : index
    Created on : Jan 23, 2024, 10:39:32 PM
    Author     : Admin
--%>
<%@page import="models.User" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../component/allCss.jsp" %>
        <style type="text/css">
            .img-bgac{
                background: url("../imgs/2696459.jpg");
                width: 100vw;
                height: 81vh;
                background-repeat: no-repeat;
                background-size: cover;
                padding-right: 0px;
            }
        </style>
    </head>
    <body>
        <%@include file="../component/navbar.jsp" %>
        <div class="container img-bgac text-center">
            <h1>Welcome to PhoneBook App</h1>
        </div>
        <%@include file="../component/footer.jsp" %>
    </body>
</html>
