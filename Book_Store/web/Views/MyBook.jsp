<%-- 
    Document   : MyBook
    Created on : Feb 16, 2024, 12:52:06 PM
    Author     : Admin
--%>
<%@page import="models.User" %> 
<%@page import="models.Book" %> 
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
        <div class="container row mt-4">
            <div class="offset-md-1 col-md-12 ">
                <table class="table">
                <thead>
                <div class="text-center mb-3"><h3>My Book Page</h3></div>

                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Author</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Image Book</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                    
                    <%List<Book> listb = (List<Book>) request.getAttribute("listb");%>
                    <%if(listb!=null){
                        int i = 1;
                        for(Book b: listb){%>
                            <tr>
                                <th scope="row"><%=i++%></th>
                                <td><%=b.getName()%></td>
                                <td><%=b.getAuthor()%></td>
                                <td><%=b.getPrice()%></td>
                                <td><%=b.getQuantity()%></td>
                                <td><img style="max-width: 60px; max-height: 60px;" src="img/<%=b.getImgname()%>"  alt="..."/></td>
                                <td><%=b.getC()==null?"undefined":b.getC().getName()%></td>
                                <td><a class="text-dark" style="text-decoration: none" href="edit?id=<%=b.getId()%>">Edit</a> &nbsp; 
                                    <a class="text-dark" style="text-decoration: none" href="delete?id=<%=b.getId()%>">Delete</a></td>
                            </tr>
                        <%}
                    }%>
                </tbody>
            </table>
            </div>
        </div>
    </body>
</html>
