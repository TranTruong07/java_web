<%-- 
    Document   : index
    Created on : Jan 30, 2024, 11:27:59 AM
    Author     : Admin
--%>
<%@page import="dal.DAO_Human" %>
<%@page import="models.Human" %>
<%@page import="models.HumanType" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                margin-top: 50px;
                border-collapse: collapse;
                width: 50%;
            }

            th, td {
                border: 1px solid black;
                padding: 8px;
                text-align: center;
            }
        </style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../component/style.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
    <center>
        <%String msg_s = (String) request.getAttribute("msg_s");%>
        <%if(msg_s!=null){
        %>
        <h5><%=msg_s%></h5>
        <%
            }%>
        <%String msg_f = (String) request.getAttribute("msg_f");%>
        <%if(msg_f!=null){
        %>
        <h5><%=msg_f%></h5>
        <%
            }%>
        <table class="text-center" >
            <tr>
                <th>NAME</th>
                <th>DOB</th>
                <th>GENDER</th>
                <th>TYPE</th>
                <th></th>

            </tr>
            <%  List<Human> list = (List<Human>) request.getAttribute("listH");
                if(list != null){
                    for(Human h: list){
            %>
            <tr>

                <td><%=h.getName()%></td>
                <td><%=h.getDob()%></td>
                <td><%=h.isGender()?"male":"female"%></td>
                <%HumanType ht = h.getType();%>
                <td><%=ht.getName()%></td>
                <td><a class="btn btn-sm btn-warning" href="Views/edit.jsp?id=<%=h.getId()%>&name=<%=h.getName()%>&dob=<%=h.getDob()%>&gender=<%=h.isGender()%>&typename=<%=h.getType().getName()%>">edit</a>
                    <a class="btn btn-sm btn-danger" href="delete_servlet?id=<%= h.getId()%>">delete</a> </td>
            </tr>
            <%
                    }
                }
             %>



        </table>
    </center>
    <div class="row mt-2">
        <div class="col-md-3"></div>
        <div class="col-md-3"><a class="btn btn-info" href="Views/insert.jsp">insert</a> </div>

    </div>


</body>
</html>
