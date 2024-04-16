<%-- 
    Document   : HomeAdmin
    Created on : Feb 25, 2024, 5:00:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../component/allCSS.jsp" %>
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
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow d-flex ">
                        <h2 class="offset-md-5 mt-1">Admin Page</h2>
                        <div class="me-5"></div>
                        <a stype="button" class="offset-md-4 btn btn-danger mr-3 ml-2 " data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Logout
                        </a>
                    </nav>


                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>User</td>
                                    <%String quantityuser = (String)request.getAttribute("quantityuser");%>
                                    <td><%=quantityuser==null?"":quantityuser%></td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                        <%String quantitybook = (String)request.getAttribute("quantitybook");%>
                                    <td>Book</td>
                                    <td><%=quantitybook==null?"":quantitybook%></td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                        <%String quantitycategory = (String)request.getAttribute("quantitycategory");%>
                                    <td>Category</td>
                                    <td><%=quantitycategory==null?"":quantitycategory%></td>
                                </tr>

                                <tr>
                                    <th scope="row">3</th>
                                        <%String quantityOrder = (String)request.getAttribute("quantityOrder");%>
                                    <td>Order Book</td>
                                    <td><%=quantityOrder==null?"":quantityOrder%></td>
                                </tr>
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
