package com.echo.controller;

import com.echo.util.ExecuteUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Integer categoryid = Integer.parseInt(request.getParameter("categoryid"));
        String categoryname = request.getParameter("categoryname");
        String description = request.getParameter("description");
        boolean update = ExecuteUtil.update(categoryid, categoryname, description);
        if (update) response.getWriter().print("更改成功");
        else response.getWriter().print("更改失败");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
