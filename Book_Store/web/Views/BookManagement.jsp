<%-- 
    Document   : BookManagement
    Created on : Mar 3, 2024, 4:43:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../component/allCSS.jsp" %>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    </head>
    <body>
        <%@include file="../component/sidebar_admin.jsp" %>
        <%@include file="../component/modal.jsp" %>
        <div class="col-md-10 ">
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-5 static-top shadow d-flex">
                        <h2 class="offset-md-4 mt-1">Book Management Page</h2>
                        <div class="me-5 pe-4"></div>
                        <a stype="button" class="offset-md-3 btn btn-danger mr-3 ml-2 " data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Logout
                        </a>
                    </nav>

                    <%String msg_f = (String)request.getAttribute("msg_f");
                    if(msg_f != null){
                    %>
                    <div class="text-center">
                        <div class="alert alert-danger" role="alert">
                            <%= msg_f%>
                        </div>
                    </div>
                    <%}%>
                    <div class="offset-md-11">
                        <a href="addBook" class="btn btn-primary">Add Book</a>
                    </div>
                    <!-- Begin Page Content -->
                    <div class="container-fluid mt-2">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Seller</th>
                                    <th scope="col">Image</th>
                                    <th scope="col">Action</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.listBook}" var="book">
                                    <tr>
                                        <th scope="row">${book.id}</th>
                                        <td>${book.name}</td>
                                        <td>${book.quantity}</td>
                                        <td>${book.price}</td>
                                        <td>${book.author}</td>
                                        <td>${book.c==null?"undefined":book.c.name}</td>
                                        <td>${book.u.id}-${book.u.name}</td>
                                        <td><img style="max-width: 60px; max-height: 60px;" src="img/${book.imgname}"  alt="..."/></td>
                                        <td>
                                            <c:if test="${book.u.r.roleid == 0}">
                                                <a class="btn btn-info" href="editBook?id=${book.id}">Edit</a>
                                            </c:if>
                                        </td>
                                        <td>
                                            <a class="btn btn-danger" href="deleteBook?id=${book.id}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <!-- /.container-fluid -->

                </div>

            </div>
            <!-- End of Content Wrapper -->
        </div>
    </div>
</body>
</html>
