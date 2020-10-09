package com.echo.controller;

import com.echo.javabean.Categories;
import com.echo.util.ExecuteUtil;
import com.echo.util.JDBCUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class CategoriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String servletPath = request.getServletPath();
        if ("/add".equals(servletPath)) add(request,response);
        else if ("/delete".equals(servletPath)) delete(request,response);
        else if ("/update".equals(servletPath)) update(request,response);
        else if ("/getall".equals(servletPath)) getall(request,response);
    }

    private void getall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Categories> all = ExecuteUtil.getAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(all);
        response.getWriter().print(s);
    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer categoryid = Integer.parseInt(request.getParameter("categoryid"));
        String categoryname = request.getParameter("categoryname");
        String description = request.getParameter("description");
        boolean update = ExecuteUtil.update(categoryid, categoryname, description);
        if (update) response.getWriter().print("更改成功");
        else response.getWriter().print("更改失败");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        boolean index = ExecuteUtil.delete(Integer.parseInt(request.getParameter("index")));
        if (index) response.getWriter().print("删除成功!");
        else response.getWriter().print("删除失败!");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
