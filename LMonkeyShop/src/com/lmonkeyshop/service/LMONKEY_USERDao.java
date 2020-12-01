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
     * 获取总记录和总条数
     * @param count 每页条数
     * @return
     */
    public static int[] totalPage(int count) {
        //arr[0]总记录数，arr[1]条数
        int[] arr = {0, 1};
        Connection conn = Basedao.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from user_info";
            ps = conn.prepareStatement(sql);
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
    public static ArrayList<LMONKEY_USER> selsetAll(int cpage,int count){
        ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
        //声明结果集
        ResultSet rs=null;
        //获取连接对象
        Connection conn=Basedao.getConnection();
        PreparedStatement ps=null;
        try {
            String sql="select * from user_info order by USER_BIRTHDAY desc limit ?,?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(cpage-1)*count);
            ps.setInt(2,count);
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
