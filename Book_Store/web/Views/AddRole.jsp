<%-- 
    Document   : AddRole
    Created on : Mar 3, 2024, 2:23:41 PM
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
        <link rel="stylesheet" href="component/mystyle.css">
    </head>
    <body>
        <%@include file="../component/sidebar_admin.jsp" %>
        <div class="col-md-10 ">
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar static-top shadow d-flex">
                        <h2 class="offset-md-5 mt-1">Add Role Page</h2>
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

                    <div class="container-fluid px-1 py-4 mx-auto">
                        <div class="row d-flex justify-content-center">
                            <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
                                <div class="card">
                                    <h5 class="text-center mb-4">ADD ROLE</h5>
                                    <form action="addRole" method="post"class="form-card" >
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">role id<span class="text-danger"> *</span></label> <input required type="text" id="fname" name="roleid" placeholder="Enter role id" onblur="validate(1)"> </div>
                                        </div>
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">role name<span class="text-danger"> *</span></label> <input required type="text" id="email" name="rolename" placeholder="Enter role name" onblur="validate(3)"> </div>
                                        </div>
                                        <div class="row justify-content-end offset-md-6">
                                            <div class="form-group col-sm-6"> <input type="submit" class="btn btn-primary" value="ADD" /></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- /.container-fluid -->

                </div>

            </div>
            <!-- End of Content Wrapper -->
        </div>
    </div>
</body>
</html>
