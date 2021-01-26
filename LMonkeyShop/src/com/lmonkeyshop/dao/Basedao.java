package com.lmonkeyshop.dao;

import java.sql.*;

/**
 * @author mzw
 * @date 2020/12/1 - 17:05
 */
public class Basedao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个连接对象
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/esmsmall?useSSL=false&serverTimezone=CST", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 增删改
     * @param sql 要执行的sql语句
     * @param params 结果集
     * @return
     */
    public static int executeIUD(String sql,Object[] params){
        Connection conn = null;
        int count=0;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (int i=0;i<params.length;i++){
                ps.setObject(i+1,params[i]);
            }
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            close(conn,ps,null);
        }
        return count;
    }
    /** 关闭的通用方法
     *       先进后出的原则
     * */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 测试数据库连接
     * @param args
     */
    public static void main(String[] args) {
        Basedao dbUtil = new Basedao();
        dbUtil.getConnection();
        System.out.println("数据库连接成功");
    }
}
