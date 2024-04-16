<%-- 
    Document   : OrderManagement
    Created on : Mar 7, 2024, 12:46:02 AM
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
                        <h2 class="offset-md-4 mt-1">Order Management Page</h2>
                        <div class="me-5 pe-3"></div>
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
                    <%String msg_s = (String)request.getAttribute("msg_s");
                    if(msg_s != null){
                    %>
                    <div class="text-center">
                        <div class="alert alert-success" role="alert">
                            <%= msg_s%>
                        </div>
                    </div>
                    <%}%>
                    <!-- Begin Page Content -->
                    <div class="container-fluid mt-2">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Id</th>
                                    <th scope="col">Customer</th>
                                    <th scope="col">Date Order</th>
                                    <th scope="col">Total Money</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.listOrder}" var="order">
                                <tr>
                                    <th scope="row">${order.oid}</th>
                                    <td>${order.customer.id}-${order.customer.name}</td>
                                    <td>${order.date}</td>
                                    <td>${order.totalCart}</td>
                                    <td>
                                        <a class="btn btn-danger" href="deleteOrder?id=${order.oid}">Delete</a>
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
