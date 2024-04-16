<%-- 
    Document   : Cart
    Created on : Feb 28, 2024, 9:07:48 PM
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
                width: 100%;
                border-collapse: collapse; /* Loại bỏ khoảng trắng giữa các ô */
            }

            /* Thiết lập kiểu đường biên và đường kẻ */
            table, th, td {
                border: none;
            }

            /* Thiết lập kiểu cho header của bảng */
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <%@include file="../component/modal.jsp" %>
        <%@include file="../component/nabar.jsp" %>
        <c:if test="${requestScope.listItem==null || requestScope.listItem.size()==0}">
            <div class="text-center">
                <div class="alert alert-warning" role="alert">
                    No Item here
                </div>
            </div>
        </c:if>
        <div class="container mt-5 mb-5">
            <div class="d-flex justify-content-center row">
                <div class="p-2 text-center">
                    <h3>Shopping Cart</h3>
                </div>
                <c:if test="${requestScope.listItem!=null && requestScope.listItem.size()>0}">
                    <div class="col-md-8 ">
                        <table >
                            <tr>
                                <th></th>
                                <th>NAME</th>
                                <th>QUANTITY</th>
                                <th>PRICE</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${requestScope.listItem}" var="item">
                                <tr>
                                    <td><div class="mr-1"><img class="rounded" src="img/${item.b.imgname}" width="70"></div></td>
                                    <td><span class="fw-bolder">${item.b.name}</span></td>
                                    <td><div class="text-center d-flex flex-row align-items-center qty">
                                            <a href="process?action=minus&id=${item.b.id}"><i class="fa fa-minus text-danger"></i></a>
                                            <h5 class="text-grey mt-1 mr-1 ml-1">${item.quantity}</h5>
                                            <a href="process?action=plus&id=${item.b.id}"><i class="fa fa-plus text-success"></i></a>
                                        </div>
                                    </td>
                                    <td><h5 class="text-grey">${item.b.price}</h5></td>
                                    <td><div class="d-flex align-items-center">
                                            <a href="process?action=delete&id=${item.b.id}"><i class="fa fa-trash mb-1 text-danger"></i></a>
                                        </div>
                                    </td>
                                </tr>


                            </c:forEach>
                        </table>

                        <div style="box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px, rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;" class="d-flex flex-row mt-5 p-2">
                            <h5>Total Money:</h5>
                            <h5 class="offset-md-9">${requestScope.totalmoney}</h5>
                        </div>
                        <div class="text-end mt-3 p-2 bg-white rounded"><a href="order" class="btn btn-warning btn-block btn-lg ml-2 pay-button" >Order</a></div>
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>
