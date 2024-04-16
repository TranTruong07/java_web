<%-- 
    Document   : UserManagement
    Created on : Mar 2, 2024, 3:42:58 PM
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
                        <h2 class="offset-md-4 mt-1">User Management Page</h2>
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
                        <a href="addUser" class="btn btn-primary">Add User</a>
                    </div>

                    <!-- Begin Page Content -->
                    <div class="container-fluid mt-2">

                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">PassWord</th>
                                    <th scope="col">Role</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:set var="i" value="${1}"></c:set>
                                <c:forEach items="${requestScope.listUser}" var="user">
                                    <tr>
                                        <th scope="row">${i}</th>
                                        <td>${user.name}</td>
                                        <td>${user.email}</td>
                                        <td>${user.password}</td>
                                        <td>${user.r.rolename}</td>
                                        <td>
                                            <a class="btn btn-info" href="editUser?id=${user.id}">Edit</a>
                                            <a class="btn btn-danger" href="deleteUser?id=${user.id}">Delete</a>
                                        </td>
                                    </tr>
                                    <c:set var="i" value="${i + 1}"></c:set>
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
