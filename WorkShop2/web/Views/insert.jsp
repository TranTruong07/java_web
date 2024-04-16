<%-- 
    Document   : insert
    Created on : Jan 31, 2024, 9:36:32 AM
    Author     : Admin
--%>
<%@page import="dal.DAO_Human" %>
<%@page import="models.HumanType" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

            h3{
                margin: 50px;
            }
            table tr{
                margin-bottom: 30px;
            }
            td, th {
                padding: 8px; /* Thêm padding cho ô */
                text-align: left; /* Căn lề văn bản sang trái */
            }
        </style>
    </head>
    <body>
    <center>
        <h3>Insert Human Page</h3>
        <div class="container">
            <form action="../insert_servlet" method="post">
                <table>
                    <tr>
                        <td>Enter Humanid: </td>
                        <td><input type="number" name="id"/> </td>
                    </tr>
                    <tr>
                        <td>Enter Human name: </td>
                        <td><input type="text" name="name"/> </td>
                    </tr>
                    <tr>
                        <td>Enter DOB: </td>
                        <td><input type="date" name="dob"/> </td>
                    </tr>
                    <tr>
                        <td>Select gender: </td>
                        <td><input checked type="radio" name="gender" value="1"/>male <input type="radio" name="gender" value="0"/>female</td>
                    </tr>
                    <tr>
                        <td>Select Human Type: </td>
                        <td><select onchange="updateHiddenField(this)" name="type">
                                <%DAO_Human dao = new DAO_Human();%>
                                <%List<HumanType> list = dao.getHumanTye();%>
                                <%
                                if(list.size()>0){
                                    for(HumanType h: list){
                                %>
                                <option value="<%= h.getName()%>" data-hidden-value="<%= h.getTypeiD()%>"> <%= h.getName()%></option>
                                <%
                                    }
                                }
                                %>
                            </select> 
                        </td>
                    </tr>
                    <%
                        if(list.size()>0){
                            HumanType h = list.get(0);
                    %>
                    <input type="hidden" name="typeid" id="typeid" value="<%=h.getTypeiD()%>"/>

                    <%
                }
                    %>

                    <tr>
                        <td></td>
                        <td><input type="submit" value="Submit"/> </td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
    <script>
        function updateHiddenField(select){
            let hiddenvalue = select.options[select.selectedIndex].getAttribute("data-hidden-value");
            console.log(hiddenvalue);
            document.getElementById("typeid").value = hiddenvalue;
        }
    </script>
</body>
</html>
