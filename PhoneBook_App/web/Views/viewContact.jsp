<%-- 
    Document   : viewContact
    Created on : Jan 23, 2024, 11:36:21 PM
    Author     : Admin
--%>
<%@page import="models.User" %>
<%@page import="models.Contact" %>
<%@page import="dao.DAO_Contact" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../component/allCss.jsp" %>
    </head>
    <body>
        <%@include file="../component/navbar.jsp" %>
        <%if(u==null){
            response.sendRedirect("login.jsp");
        }%>
        <%DAO_Contact daoc = new DAO_Contact();%>
        <% List<Contact> list = daoc.getListContacts(u==null?0:u.getId());%>
        <div class="container">
            
            <div>
                <%String msg_s = (String)session.getAttribute("msg_s");%>
                    <%if(msg_s!=null){
                        %>
                        <p class="text-center text-success"><%=msg_s%></p>
                        <% session.removeAttribute("msg_s");}%>
                    <%String msg_f = (String)session.getAttribute("msg_f");%>
                    <%if(msg_f!=null){
                        %>
                        <p class="text-center text-danger"><%=msg_f%></p>
                        <%session.removeAttribute("msg_f");}%>
            </div>
            
            <div class="row text-center ">
        <% for(Contact c: list){
            %>
                <div class="card col-md-4 mt-3">
                    <div class="card-body">
                        <h4>Name: <%=c.getName()%></h4>
                        <h5>Phone: <%=c.getPhoneNo()%></h5>
                        <h5>Email: <%=c.getEmail()%></h5>
                        <h5>About: <%=c.getAbout()%></h5>
                        <div class="text-center">
                            <a href="updateContact.jsp?name=<%=c.getName()%>&phoneNo=<%=c.getPhoneNo()%>&email=<%=c.getEmail()%>&about=<%=c.getAbout()%>" 
                               class="btn btn-warning">Update</a>
                            <a href="../removeContact_servlet?id=<%=u.getId()%>&phoneNo=<%=c.getPhoneNo()%>" class="btn btn-danger">Delete</a>
                        </div>
                    </div>
                </div>
            <%
            }%>
            </div>
        </div>
        
    </body>
</html>
