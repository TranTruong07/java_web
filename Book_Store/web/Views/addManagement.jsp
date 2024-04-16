<%-- 
    Document   : addManagement
    Created on : Mar 4, 2024, 9:06:12 PM
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
        <%@include file="../component/modal.jsp" %>
        <div class="col-md-10 ">
            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">
                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar static-top shadow d-flex">
                        <h2 class="offset-md-5 mt-1">Add Book Page</h2>
                        <div class="me-5"></div>
                        <a stype="button" class="offset-md-4 btn btn-danger mr-3 ml-2 " data-bs-toggle="modal" data-bs-target="#exampleModal">
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

                    <div class="container-fluid px-1 py-4 mx-auto">
                        <div class="row d-flex justify-content-center">
                            <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
                                <div class="card">
                                    <h5 class="text-center mb-4">ADD Book</h5>
                                    <form action="addBook" method="post"class="form-card" enctype="multipart/form-data" >
                                        <input type="hidden" name="userid" value="${sessionScope.user.getId()}"/>
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Book Name:<span class="text-danger"> *</span></label> <input required type="text" id="fname" name="name" placeholder="Enter your book name" onblur="validate(1)"> </div>
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Author:<span class="text-danger"> *</span></label> <input required type="text" id="lname" name="author" placeholder="Enter author book" onblur="validate(2)"> </div>
                                        </div>
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Price:<span class="text-danger"> *</span></label> <input required type="text" id="fname" name="price" placeholder="Enter price name" onblur="validate(1)"> </div>
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Quantity:<span class="text-danger"> *</span></label> <input required type="number" id="lname" name="quantity" placeholder="Enter quantity book" onblur="validate(2)"> </div>
                                        </div>
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex">
                                                <label for="inputPassword4" class="form-control-label px-3">Select image file:</label>
                                                <input type="file" name="imgname" class="form-control" id="inputPassword4">
                                            </div>
                                            <div class="form-group col-sm-6 flex-column d-flex"> 
<!--                                                <label class="form-control-label px-3">role<span class="text-danger"> *</span></label> -->
                                                <label for="inputState" class="form-control-label px-3">Select Category:</label>
                                                <select name="selectCategory">
                                                    <option value="undefined" selected>Choose...</option>
                                                    <c:forEach items="${requestScope.listc}" var="c">
                                                        <option value="${c.id}">${c.name}</option>
                                                    </c:forEach>
                                                </select>
                                                
                                                <!--                                                <input type="text" id="mob" name="mob" placeholder="" onblur="validate(4)"> -->
                                            </div>
                                        </div>
                                        <div class="row justify-content-end offset-md-9">
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
