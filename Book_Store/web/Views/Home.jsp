<%-- 
    Document   : Home
    Created on : Feb 13, 2024, 10:04:06 AM
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
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <style>
            table {
                border-collapse: separate;
                border-spacing: 50px;
            }
        </style>
    </head>
    <body>
        <%@include file="../component/modal.jsp" %>

        <div >
            <img src="https://images.ctfassets.net/9htf9uzhsn4z/3iwIMQH1L2FjOX7wdXLluQ/c6709e9cb7e5f4c6618d09f07df7ccdf/lulu-sell-on-lulu-main-banner-desktop.jpg?w=2880&h=960&fm=webp" class="img-fluid" alt="...">
        </div>
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
        
        <div class="d-flex justify-content-end mt-3 me-5 " >
            <a style="position: relative;" class="btn" href="cart">
                <i style="font-size: 25px;"  class="fa-solid fa-cart-shopping"></i> 
                <label style="position: absolute; bottom: -3px; left: 75%; color: #fa1e1e">${sessionScope.n}</label>
            </a>
        </div>

        <div class="container-fluid row mt-3 mb-3">
            <div class="col-md-2 ">
                <div style="height: 100px"></div>
                <%String select = (String)request.getAttribute("select");%>

                <form action="findProductByPrice">
                    <div>
                        <table style="border-spacing: 10px;"  class="m-auto">
                            <tr>
                                <th><h3>Filter</h3></th>
                                <th></th>
                            </tr>

                            <tr>
                                <td>Find follow price</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>ALL</td>
                                <td><input <%=select==null?"checked":""%> value="1000" name="price" type="radio" /></td>
                            </tr>
                            <tr>
                                <td>than 100.000</td>
                                <td><input <%=select!=null?select.equals("100")?"checked":"":""%> value="100" name="price" type="radio" /></td>
                            </tr>
                            <tr>
                                <td>50.000 -> 100.000</td>
                                <td><input <%=select!=null?select.equals("50")?"checked":"":""%> value="50" name="price" type="radio" /></td>
                            </tr>
                            <tr>
                                <td>less than 50.000</td>
                                <td><input <%=select!=null?select.equals("0")?"checked":"":""%> value="0" name="price" type="radio" /></td>
                            </tr>

                            <tr>
                                <td><input class="btn btn-primary btn-sm" type="submit" value="View"/> </td>
                                <td></td>
                            </tr>
                        </table>
                    </div>
                </form>
            </div>
            <div class="col-md-8 ms-5 ps-5 row">
                <%List<Book> listb = (List<Book>) request.getAttribute("listb");%>
                <%if(listb != null){
                    for(Book b: listb){
                %>
                <div class="col-md-4 mb-3">
                    <form >

                        <div class="card mb-3 my-card " style="width: 300px;
                             height: 480px;
                             background: rgb(236, 236, 236);"
                             >
                            <div style="max-width: 300px; max-height: 250px">
                                <img style="width: 100%; height: 100%" src="img/<%=b.getImgname()%>"  class="card-img-top" alt="...">
                            </div>
                            <div class="card-body mt-1">
                                <h5 class="card-title text-center fw-bold"><%=b.getName()%></h5>
                                <div class="row">
                                    <div class="col-md-6">
                                        <h7 class="fw-bold">Author:</h7>
                                    </div>
                                    <div class="col-md-6">
                                        <h7><%=b.getAuthor()%></h7>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <h7 class="fw-bold">Category:</h7>
                                    </div>
                                    <div class="col-md-6">
                                        <h7><%=b.getC()==null?"undefined":b.getC().getName()%></h7>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <h7 class="fw-bold">Quantity:</h7>
                                    </div>
                                    <div class="col-md-6">
                                        <h7><%=b.getQuantity()%></h7>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <h7 class="fw-bold">Price:</h7>
                                    </div>
                                    <div class="col-md-6">
                                        <h7 class="text-red"><%=b.getPrice()%></h7>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12 text-end"> <!-- Sử dụng lớp 'text-end' ở đây -->
                                        <a class="btn btn-primary" href="buy?id=<%=b.getId()%>" >buy</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
                <%
            }
            }%>



            </div>
        </div>

    </body>
</html>
