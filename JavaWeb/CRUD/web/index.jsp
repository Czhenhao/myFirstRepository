<%@ page import="com.echo.util.JDBCUtil" %>
<%@ page import="com.echo.javabean.Categories" %>
<%@ page import="java.util.List" %>
<%@ page import="com.echo.util.ExecuteUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        body {
            background-color: aqua;
        }

        table {
            width: 1000px;
            height: 400px;
        }

        h1 {
            text-align: center;
            color: blue;
        }

        p {
            font-size: 20px;
        }

        div {
            text-align: center;
        }

        #updateWin, #win {
            position: absolute;
            left: 200px;
            height: 200px;
            width: 1000px;
            height: 200px;
            background-color: darkgray;
            display: none;
            opacity: 0.9;
        }

        .winHead {
            height: 20%;
            color: blue;
        }

        .winBody {
            height: 60%;
            color: rebeccapurple;
        }

        .winTail {
            height: 20%;
            color: cornflowerblue;
        }

        #cancelWin, #updateCancelWin {
            text-decoration: none;
            float: right;
        }

    </style>
</head>
<body>
<h1>所有产品系列</h1>
<p><a href="javascript:void(0)">新加产品系列</a></p>
<%
    List<Categories> all = ExecuteUtil.getAll();
%>
<div id="win">
    <div class="winHead">新增产品系列
        <a href="javascript:void(0)" id="cancelWin">关闭</a>
    </div>
    <div class="winBody">
        类别名称：<input id="CategoryName" type="text">
        类别描述：<input id="Description" type="text">
    </div>
    <div class="winTail">
        <input id="submitWin" type="submit" value="提交">
        <input id="resetWin" type="reset" value="重置">
    </div>
</div>

<div id="updateWin">
    <div class="winHead">新增产品系列
        <a href="javascript:void(0)" id="updateCancelWin">关闭</a>
    </div>
    <div class="winBody">
        类别名称：<input id="updateCategoryName" type="text">
        类别描述：<input id="updateDescription" type="text">
    </div>
    <div class="winTail">
        <input id="updatesubmitWin" type="submit" value="提交">
        <input id="updateresetWin" type="reset" value="重置">
    </div>
</div>

<table cellspacing="0px" cellpadding="5px" border="1px" style="margin: auto">
    <tr>
        <th>类别编号</th>
        <th>类别名称</th>
        <th colspan="3">类别描述</th>
    </tr>

    <% for (Categories categories : all) { %>

    <tr>
        <td><%=categories.getCategoryID()%>
        </td>
        <td><%=categories.getCategoryName()%>
        </td>
        <td><%=categories.getDescription()%>
        </td>
        <td><a href="#" class="delete">删除</a></td>
        <td><a href="#" class="updata">更新</a></td>
    </tr>
    <% } %>
</table>
</body>
<script src="js/jquery-1.12.4.js"></script>
<script>
  $(function () {
    //=======================================================================================添加
    //点击弹出模态窗
    $("a:first").click(function () {
      $("#win").slideDown();
    })

    //点击关闭模态窗
    $("#cancelWin").click(function () {
      $("#win").slideUp();
    })

    //清除模态窗表单数据
    $("#resetWin").click(function () {
      $("input:lt(2)").val("")
    })

    //提交添加表单
    $("#submitWin").click(function () {
      let CategoryName = $("#CategoryName").val();
      let Description = $("#Description").val();
      if ((CategoryName != null && CategoryName != "") && (Description != null && Description != "")) {
        $.ajax({
          method: "POST",
          url: "add",
          data: {CategoryName: CategoryName, Description: Description},
          success: function (data) {
            window.location.href = "index.jsp"
          }
        })
        $("#win").slideUp();
      } else alert("不能为空!")

    })


    //=================================================================================================更新
    //点击更新，弹出模态窗
    $(".updata").click(function () {
      parent = $(this).parent().parent();
      let CategoryName = parent.children().get(1).innerHTML;
      let Desription = parent.children().get(2).innerHTML;
      $("#updateCategoryName").val(CategoryName.trim());
      $("#updateDescription").val(Desription.trim());
      $("#updateWin").slideDown()
    })
    //关闭模态窗
    $("#updateCancelWin").click(function () {
      $("#updateWin").slideUp()
    })
    //重置模态窗表单的数据
    $("#updateresetWin").click(function () {
      $("input:gt(2):lt(3)").val("")
    })

    $("#updatesubmitWin").click(function () {
      let categoryid = parseInt(parent.children().get(0).innerHTML);
      let categoryname = $("#updateCategoryName").val().trim();
      let description = $("#updateDescription").val().trim();
      if ((categoryname != null && categoryname != "") && (description != null && description != "")) {
        $.ajax({
          method: "POST",
          url: "update",
          data: {categoryid: categoryid, categoryname: categoryname, description: description},
          success: function (data) {
            window.location.href = "index.jsp"
          }
        })
        $("#win").slideUp();
      } else alert("不能为空!")
    })

    //=====================================================================删除
    $(".delete").click(function () {
      if (window.confirm("确认删除?")){
        let innerText = $(this).parent().parent().children().get(0).innerText;
        let index = parseInt(innerText)
        $.ajax({
          method : "POST",
          url : "delete",
          data : { index : index},
          success : function(data){
            window.location.href = "index.jsp"
          }
        })
      }
    })
  })
</script>
</html>
