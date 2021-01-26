package com.lmonkeyshop.service;

import com.lmonkeyshop.dao.Basedao;
import com.lmonkeyshop.entity.LMONKEY_CATEGORY;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author mzw
 * @date 2021/1/21 - 16:52
 */
public class LMONKEY_CATEGORYDao {

    /**
     * 查询所有分类列表
     * @return
     */
    public static ArrayList<LMONKEY_CATEGORY> selectAll(){
        ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
        //声明结果集
        ResultSet rs=null;
        //获取连接对象
        Connection conn=Basedao.getConnection();
        PreparedStatement ps=null;
        try {

            String sql="select * from lmonkey_category ";
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                LMONKEY_CATEGORY category = new LMONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Basedao.close(conn,ps,rs);
        }
        return list;
    }

    /**
     * 前台查询分类
     * @param flag flag="father" flag="child"
     * @return
     */
    public static ArrayList<LMONKEY_CATEGORY> selectCate(String flag){
        ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
        //声明结果集
        ResultSet rs=null;
        //获取连接对象
        Connection conn=Basedao.getConnection();
        PreparedStatement ps=null;
        try {
            String sql=null;
            if (flag!=null&&flag.equals("father")){
                sql="select * from lmonkey_category where CARE_PARENT_ID=0";
            }else {
                sql="select * from lmonkey_category where CARE_PARENT_ID!=0";
            }
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                LMONKEY_CATEGORY category = new LMONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Basedao.close(conn,ps,rs);
        }
        return list;
    }

    /**
     * 添加分类
     * @param lmonkey_category
     * @return
     */
    public static int insert(LMONKEY_CATEGORY lmonkey_category){
        String sql = "insert into lmonkey_category value(null,?,?)";
        Object[] prarms= {
                lmonkey_category.getCATE_NAME(),
                lmonkey_category.getCATE_PARENT_ID()
        };
        return Basedao.executeIUD(sql,prarms);
    }

    /**
     * 通过id查询分类
     * @param id
     * @return
     */
    public static LMONKEY_CATEGORY selectByID(int id){
        LMONKEY_CATEGORY category=null;
        //声明结果集
        ResultSet rs=null;
        //获取连接对象
        Connection conn=Basedao.getConnection();
        PreparedStatement ps=null;
        try {
            String sql="select m.* from lmonkey_category m where CATE_ID= ? ";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while (rs.next()) {
                category = new LMONKEY_CATEGORY(
                        rs.getInt("CATE_ID"),
                        rs.getString("CATE_NAME"),
                        rs.getInt("CATE_PARENT_ID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Basedao.close(conn,ps,rs);
        }
        return category;
    }

    /**
     * 修改分类
     * @param lmonkey_category
     * @return
     */
    public static int update(LMONKEY_CATEGORY lmonkey_category){
        String sql = "update lmonkey_category set CATE_NAME=?,CATE_PARENT_ID=? where CATE_ID=?";
        Object[] prarms={
                lmonkey_category.getCATE_NAME(),
                lmonkey_category.getCATE_PARENT_ID(),
                lmonkey_category.getCATE_ID()
                };
        return Basedao.executeIUD(sql,prarms);
    }

    /**
     * 删除分类
     * @param id
     * @return
     */
    public static int delByID(int id){
        String sql = "delete from lmonkey_category where CATE_ID=?";
        Object[] prarms={id};
        return Basedao.executeIUD(sql,prarms);
    }
}
