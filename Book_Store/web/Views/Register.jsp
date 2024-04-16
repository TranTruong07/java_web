<%-- 
    Document   : Register
    Created on : Feb 13, 2024, 9:40:26 PM
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
        <%String msg_s = (String)request.getAttribute("msg_s");
        if(msg_s != null){
        %>
            <div class="text-center">
            <div class="alert alert-success" role="alert">
                <%= msg_s%>
            </div>
            </div>
        <%}%>
        <div class="container row p-3">
        
            <div class="form_body col-md-5 offset-md-5 border mr-3">
                <h3 class="text-center">Registration Page</h3>
                <form action="register" method="post">
                    <div class="form-group mb-4">
                        <label for="exampleInputEmail1">Enter Name</label>
                        <input required name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
                    </div>
                    <div class="form-group mb-4">
                        <label for="exampleInputEmail1">Email address</label>
                        <input required name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    </div>
                    <div class="form-group mb-4">
                        <label for="exampleInputPassword1">Password</label>
                        <input required name="pass" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <div class="text-center pb-3">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
