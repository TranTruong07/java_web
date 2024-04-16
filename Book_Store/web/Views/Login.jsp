<%-- 
    Document   : login
    Created on : Feb 13, 2024, 8:19:59 PM
    Author     : Admin
--%>
<%@page import="models.User" %> 
<%@page import="models.Category" %> 
<%@page import="java.util.List" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../component/allCSS.jsp" %>
    </head>
    <body>
        <%@include file="../component/nabar.jsp" %>
        <%String msg_f = (String)request.getAttribute("msg_f");
        if(msg_f != null){
        %>
            <div class="text-center">
            <div class="alert alert-danger" role="alert">
                <%= msg_f%>
            </div>
        </div>
        <%}%>
        
        <div class="container row p-3 mr-3">
            <div class="col-md-5 offset-md-5 border ">
                <h3 class="text-center">Login Page</h3>
                <form action="login" method="post">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Email address</label>
                        <input required name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input required name="pass" type="password" class="form-control" id="exampleInputPassword1">
                    </div>
                    <button type="submit" class="btn btn-primary mb-3 offset-md-5 ">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>
