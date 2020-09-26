package com.echo.controller;

import com.echo.javabean.Categories;
import com.echo.util.ExecuteUtil;
import com.echo.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String categoryName = request.getParameter("CategoryName");
        String description = request.getParameter("Description");
        Connection connection = JDBCUtil.getConnection();
        boolean add = ExecuteUtil.add(categoryName, description);
        if (add) response.getWriter().print("添加成功！");
        else response.getWriter().print("添加失败");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
