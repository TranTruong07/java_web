<%-- 
    Document   : addPhone
    Created on : Jan 23, 2024, 11:35:41 PM
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
        <%if(u==null){
            response.sendRedirect("login.jsp");
            }%>
        <div class="container row p-3">

            <div class="form_body col-md-5 offset-md-6 border mr-3">
                <h3 class="text-center text-info">Add Contact</h3>
                <form action="../addContact_servlet" method="get">
                    
                    <%String msg_s = (String)session.getAttribute("msg_s");%>
                    <%if(msg_s!=null){
                        %>
                        <p class="text-center text-success"><%=msg_s%></p>
                        <% session.removeAttribute("msg_s");}%>
                    <%String msg_f = (String)session.getAttribute("msg_f");%>
                    <%if(msg_f!=null){
                        %>
                        <p class="text-center text-danger"><%=msg_f%></p>
                        <%session.removeAttribute("msg_f");}%>
                        <input type="hidden" name="id" value="<%= u==null?"":u.getId()%>"/>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Enter Name</label>
                        <input required name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">Enter Phone No</label>
                        <input required name="phoneNo" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                    <div class="form-group">
                        <textarea name="about" class="form-control" id="id" name="name" rows="5" cols="55" placeholder="Enter About"></textarea>
                    </div>
                    <div class="text-center pb-3">
                        <button type="submit" class="btn btn-info">Save Contact</button>
                    </div>
                </form>
            </div>
        </div>
        <div style="margin-top: 37px;">
            <%@include file="../component/footer.jsp" %>
        </div>
    </body>
</html>
