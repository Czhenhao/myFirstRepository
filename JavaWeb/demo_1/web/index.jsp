<%--
  Created by IntelliJ IDEA.
  User: 13437518533
  Date: 2020/9/18
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style type="text/css">
        textarea {
            resize: none;
        }
      body{
        background-color: cornflowerblue;
      }
    </style>
</head>
<body>
<center>
    <form action="/result.jsp" method="get">
        <input type="text" name="lastname">Last Name<br>
        <input type="text" name="firstname">First Name<br>
        <input type="checkbox" value="knowingjava"  checked name="knowing">knowingjava
        <input type="checkbox" value="knowingc++" name="knowing">knowingc++<br>
        <input type="radio"  name="working">working<br>
        <select size="3" name="job">
            <option value="programer">Programer</option>
            <option value="documentation">Documentation</option>
            <option value="Other">Other</option>
        </select>
        Job
        <select name="rank">
            <option value="low">low</option>
            <option value="middle" selected>middle</option>
            <option value="high">high</option>
        </select>
        Rank<br>
        <textarea name="content" cols="30" rows="10"></textarea><br>
        <input type="hidden" name="hidden" value="hiddenvalue">
        <input type="submit" value="提交">
        <input type="reset" value="重置">

    </form>
</center>
</body>
</html>
`