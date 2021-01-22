package com.lmonkeyshop.service;

import com.lmonkeyshop.dao.Basedao;
import com.lmonkeyshop.entity.LMONKEY_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author mzw
 * @date 2020/12/1 - 17:06
 */
public class LMONKEY_USERDao {
    /**
     * 插入数据库
     * @param lmonkey_user
     * @return
     */
    public static int insert(LMONKEY_USER lmonkey_user){
        String sql = "insert into user_info values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
        Object[] prarms={
                lmonkey_user.getUSER_ID(),
                lmonkey_user.getUSER_NAME(),
                lmonkey_user.getUSER_PASSWORD(),
                lmonkey_user.getUSER_SEX(),
                lmonkey_user.getUSER_BIRTHDAY(),
                lmonkey_user.getUSER_IDENITY_CODE(),
                lmonkey_user.getUSER_EMAIL(),
                lmonkey_user.getUSER_MOBILE(),
                lmonkey_user.getUSER_ADDRESS(),
                lmonkey_user.getUSER_STATUS()};
        return Basedao.executeIUD(sql,prarms);
    }

    /**
     *
     * 删除用户
     * @param id
     * @return
     */
    public static int delByID(String id){
        String sql = "delete from user_info where USER_ID=? and USER_STATUS!=2";
        Object[] prarms={id};
        return Basedao.executeIUD(sql,prarms);
    }

    /**
     * 修改用户数据
     * @param lmonkey_user
     * @return
     */
    public static int update(LMONKEY_USER lmonkey_user){
        String sql = "update user_info set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d')," +
                "USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";
        Object[] prarms={
                lmonkey_user.getUSER_NAME(),
                lmonkey_user.getUSER_PASSWORD(),
                lmonkey_user.getUSER_SEX(),
                lmonkey_user.getUSER_BIRTHDAY(),
                lmonkey_user.getUSER_IDENITY_CODE(),
                lmonkey_user.getUSER_EMAIL(),
                lmonkey_user.getUSER_MOBILE(),
                lmonkey_user.getUSER_ADDRESS(),
                lmonkey_user.getUSER_STATUS(),
                lmonkey_user.getUSER_ID()};
        return Basedao.executeIUD(sql,prarms);
    }

    /**
     * 获取总记录和总条数
     * @param count 每页条数
     * @return
     */
    public static int[] totalPage(int count ,String keyword) {
        //arr[0]总记录数，arr[1]条数
        int[] arr = {0, 1};
        Connection conn = Basedao.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql="";
            if (keyword!=null){
                sql = "select count(*) from user_info where USER_NAME like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
            }else {
                sql = "select count(*) from user_info";
                ps = conn.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                arr[0] = rs.getInt(1);
                if (arr[0] % count == 0) {
                    arr[1] = arr[0] / count;
                } else {
                    arr[1] = arr[0] / count + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Basedao.close(conn, ps, rs);
        }
        return arr;
    }

    public static int selectByName(String id) {
        int count =0;
        Connection conn = Basedao.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from user_info where USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                count=rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Basedao.close(conn, ps, rs);
        }
        return count;
    }
    public static int selectByNP(String username,String pwd) {
        int count =0;
        Connection conn = Basedao.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from user_info where USER_ID=? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                count=rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Basedao.close(conn, ps, rs);
        }
        return count;
    }
    public static LMONKEY_USER selectAdmin(String name,String pwd) {
        LMONKEY_USER lmonkey_user=null;
        //声明结果集
        ResultSet rs=null;
        //获取连接对象
        Connection conn=Basedao.getConnection();
        PreparedStatement ps=null;
        try {
            String sql="select m.*, DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from user_info m where USER_ID= ? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pwd);

            rs=ps.executeQuery();
            while (rs.next()) {
                lmonkey_user = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Basedao.close(conn,ps,rs);
        }
        return lmonkey_user;
    }
    /**
     * 查找
     * @param id
     * @return
     */
    public static LMONKEY_USER selectByID(String id){
        LMONKEY_USER user=null;
        //声明结果集
        ResultSet rs=null;
        //获取连接对象
        Connection conn=Basedao.getConnection();
        PreparedStatement ps=null;
        try {
            String sql="select m.*, DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from user_info m where USER_ID= ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);

            rs=ps.executeQuery();
            while (rs.next()) {
                user = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Basedao.close(conn,ps,rs);
        }
        return user;
    }

    /**
     * 查询
     * @param cpage
     * @param count
     * @param keyword
     * @return
     */
    public static ArrayList<LMONKEY_USER> selectAll(int cpage, int count, String keyword){
        ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
        //声明结果集
        ResultSet rs=null;
        //获取连接对象
        Connection conn=Basedao.getConnection();
        PreparedStatement ps=null;
        try {
            String sql="";
            if (keyword!=null){
                sql="select * from user_info where USER_NAME like ? order by USER_BIRTHDAY desc limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+keyword+"%");
                ps.setInt(2,(cpage-1)*count);
                ps.setInt(3,count);
            }else {
                sql="select * from user_info order by USER_BIRTHDAY desc limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,(cpage-1)*count);
                ps.setInt(2,count);
            }

            rs=ps.executeQuery();
            while (rs.next()) {
                LMONKEY_USER user = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("USER_BIRTHDAY"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Basedao.close(conn,ps,rs);
        }
        return list;
    }
}
