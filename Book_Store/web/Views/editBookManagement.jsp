<%-- 
    Document   : editBookManagement
    Created on : Mar 4, 2024, 10:10:25 PM
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
                        <h2 class="offset-md-5 mt-1">Edit Book Page</h2>
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
                                    <h5 class="text-center mb-4">Edit Book</h5>
                                    <form action="editBook" method="post"class="form-card" enctype="multipart/form-data" >
                                        <input type="hidden" name="userid" value="${sessionScope.user.getId()}"/>
                                        <c:set var="book" value="${requestScope.book}"></c:set>
                                        <input type="hidden" name="bookid" value="${book.id}"/>
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Book Name:<span class="text-danger"> *</span></label> <input required type="text" id="fname" name="name" value="${book.name}" placeholder="Enter your book name" onblur="validate(1)"> </div>
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Author:<span class="text-danger"> *</span></label> <input required type="text" id="lname" name="author" value="${book.author}" placeholder="Enter author book" onblur="validate(2)"> </div>
                                        </div>
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Price:<span class="text-danger"> *</span></label> <input required type="text" id="fname" name="price" value="${book.price}" placeholder="Enter price book" onblur="validate(1)"> </div>
                                            <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Quantity:<span class="text-danger"> *</span></label> <input required type="number" id="lname" name="quantity" value="${book.quantity}" placeholder="Enter quantity book" onblur="validate(2)"> </div>
                                        </div>
                                        <div class="row justify-content-between text-left">
                                            <div class="form-group col-sm-6 flex-column d-flex">
                                                <input type="hidden" name="imgnameold" value="${book.imgname}"/>
                                                <label for="inputPassword4" class="form-control-label px-3">Select image file:</label>
                                                <input type="file" name="imgname" class="form-control" id="inputPassword4">
                                            </div>
                                            <div class="form-group col-sm-6 flex-column d-flex"> 
                                                <!--                                                <label class="form-control-label px-3">role<span class="text-danger"> *</span></label> -->
                                                <label for="inputState" class="form-control-label px-3">Select Category:</label>
                                                <select name="selectCategory">
                                                    <option ${book.c.id==0?"selected":""} value="0" >Choose...</option>
                                                    <c:forEach items="${requestScope.listc}" var="c">
                                                        <option ${book.c.id==c.id?"selected":""} value="${c.id}">${c.name}</option>
                                                    </c:forEach>
                                                </select>

                                                <!--                                                <input type="text" id="mob" name="mob" placeholder="" onblur="validate(4)"> -->
                                            </div>
                                        </div>
                                        <div class="row justify-content-end offset-md-9">
                                            <div class="form-group col-sm-6"> <input type="submit" class="btn btn-primary" value="SAVE" /></div>
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