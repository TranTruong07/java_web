<%-- 
    Document   : RoleManagement
    Created on : Mar 3, 2024, 12:41:12 PM
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
                        <h2 class="offset-md-4 mt-1">Role Management Page</h2>
                        <div class="me-5 pe-5"></div>
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
                        <a href="addRole" class="btn btn-primary">Add Role</a>
                    </div>

                    <!-- Begin Page Content -->
                    <div class="container-fluid mt-2">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${requestScope.listRole}" var="role">
                                    <tr>
                                        <th scope="row">${role.roleid}</th>
                                        <td>${role.rolename}</td>
                                        <td>
                                            <a class="btn btn-danger" href="deleteRole?roleid=${role.roleid}">Delete</a>
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
