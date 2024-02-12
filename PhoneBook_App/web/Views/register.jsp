<%-- 
    Document   : register
    Created on : Jan 23, 2024, 11:22:50 PM
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
    </head>
    <body>
        <%@include file="../component/navbar.jsp" %>
        <div class="container row p-3">

            <div class="form_body col-md-5 offset-md-6 border mr-3">
                <h3 class="text-center text-primary">Registration Page</h3>
                <form action="../regis_servlet" method="post">
                    
                    <div class="text-center text-success">
                        <%String msg_s = (String)session.getAttribute("msg_s");
                        if(msg_s != null){
                        %>
                        <p><%= msg_s %></p>
                        <%
                            session.removeAttribute("msg_s");
                        }%>
                    </div>
                    <div class="text-center text-danger">
                        <%String msg_f = (String)session.getAttribute("msg_f");
                        if(msg_f != null){
                        %>
                        <p><%= msg_f %></p>
                        <%
                            session.removeAttribute("msg_f");
                        }%>
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputEmail1">Enter Name</label>
                        <input required name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter name">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input required name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input required name="pass" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <div class="text-center pb-3">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form>
            </div>
        </div>
        <div style="margin-top: 182px;">
            <%@include file="../component/footer.jsp" %>
        </div>

    </body>
</html>
