<%-- 
    Document   : AddBook
    Created on : Feb 15, 2024, 10:06:05 AM
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
        <%@include file="../component/modal.jsp" %>
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
        <div class="container row mt-5">
            <div class="col-md-7  offset-md-4">
                <h4 class="text-center fw-bold">Add Book Page</h4>
                <form action="add" method="post" class="row g-3" enctype="multipart/form-data">
                    <input type="hidden" name="userid" value="${sessionScope.user.getId()}"/>
                    <div class="col-12">
                        <label for="inputAddress" class="form-label">Book Name:</label>
                        <input required name="name" type="text" class="form-control" id="" placeholder="">
                    </div>
                    <div class="col-md-6">
                        <label for="inputEmail4" class="form-label">Author:</label>
                        <input type="text" required name="author" class="form-control" id="">
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Price:</label>
                        <input type="text" name="price" class="form-control" id="inputPassword4">
                    </div>

                    <div class="col-md-6">
                        <label for="inputEmail4" class="form-label">Quantity:</label>
                        <input type="number" required name="quantity" class="form-control" id="">
                    </div>
                    <div class="col-md-6">
                        <label for="inputPassword4" class="form-label">Select image file:</label>
                        <input type="file" name="imgname" class="form-control" id="inputPassword4">
                    </div>
                    
                    <div class="col-12">
                        <label for="inputState" class="form-label">Select Category:</label>
                        <select name="selectCategory" id="inputState" class="form-select">
                            <option value="undefined" selected>Choose...</option>
                            <%if(listc != null){
                                for(Category c: listc){
                            %>
                            <option value="<%=c.getId()%>"><%=c.getName()%></option>
                            <%
                                }
                            }%>
                        </select>
                    </div>
                    
                    <div class="col-12 text-end">
                        <button type="submit" class="btn btn-primary ">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
