<%--
  Created by IntelliJ IDEA.
  User: 13437518533
  Date: 2020/9/18
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<h1>Parameter Lists</h1>
<center>
<table border="1px" cellpadding="3px" cellspacing="0px">
    <thead>
    <tr>
        <td>Name</td>
        <td>Value</td>
    </tr>
    </thead>
    <tr>
        <%
            String lastname = request.getParameter("lastname");
            if (lastname != null && lastname != "") {
        %>
        <td>lastname</td>
        <td><%=lastname%>
        </td>
        <%}%>
    </tr>
    <tr>
        <%
            String firstname = request.getParameter("firstname");
            if (firstname != null && firstname != "") {
        %>
        <td>firstname</td>
        <td><%=firstname%>
        </td>
        <%}%>
    </tr>
    <%
        String[] knowings = request.getParameterValues("knowing");
        if (knowings != null) {
            for (String s : knowings) {

    %>
    <tr>
        <td><%=s%>
        </td>
        <td>on</td>
    </tr>
    <%
            }
        }
    %>
    <tr>
        <td>working</td>
        <td><%=request.getParameter("working")%></td>
    </tr>
    <tr>
        <td>Job</td>
        <td><%=request.getParameter("job")%></td>
    </tr>
    <tr>
        <td>Rank</td>
        <td><%=request.getParameter("rank")%></td>
    </tr>
    <tr>
        <td>content</td>
        <td><%=request.getParameter("content")%></td>
    </tr>
    <tr>
        <td>hidden</td>
        <td><%=request.getParameter("hidden")%></td>
    </tr>
</table>
</center>
</body>
</html>
