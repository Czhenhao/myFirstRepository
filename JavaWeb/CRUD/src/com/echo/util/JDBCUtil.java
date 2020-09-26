package com.echo.util;

import com.echo.javabean.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

public class JDBCUtil {
    private JDBCUtil() {
    }
    private static ResourceBundle bundle = null;

    static { //注册驱动
        try {
            bundle = ResourceBundle.getBundle("resource/DB");
            Class.forName(bundle.getString("classname"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    bundle.getString("url"),
                    bundle.getString("username"),
                    bundle.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
