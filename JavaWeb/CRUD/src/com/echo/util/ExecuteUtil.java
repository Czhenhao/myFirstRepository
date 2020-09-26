package com.echo.util;

import com.echo.javabean.Categories;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExecuteUtil {
    private ExecuteUtil(){}

    //查询所有数据
    public static List<Categories> getAll() {
        Connection connection= JDBCUtil.getConnection();
        String selectAllSql = "SELECT * FROM Categories";
        List<Categories> list = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(selectAllSql);
            while (resultSet.next()) {
                list.add(new Categories(
                        resultSet.getInt("CategoryID"),
                        resultSet.getString("CategoryName"),
                        resultSet.getString("Description"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,statement,connection);
        }
        return list;
    }

    //添加
    public static boolean add(String CategoryName,String Description){
        String addSql = "insert into Categories(CategoryName,Description) values(?,?)";
        Connection connection= JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(addSql);
            preparedStatement.setString(1,CategoryName);
            preparedStatement.setString(2,Description);
            return preparedStatement.executeUpdate() > 0 ? true :false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return false;
    }

    //更新
    public static boolean update(Integer CategoryID,String CategoryName,String Description){
        String updateSql = "update Categories set CategoryName = ?,Description = ? where CategoryID = ?";
        Connection connection= JDBCUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1,CategoryName);
            preparedStatement.setString(2,Description);
            preparedStatement.setInt(3,CategoryID);
            return preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //删除
    public static boolean delete (Integer id){
        Connection connection= JDBCUtil.getConnection();
        String deleteSql = "delete from Categories where CategoryID = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(null,preparedStatement,connection);
        }
        return false;
    }
}
