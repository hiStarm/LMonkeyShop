package com.lmonkeyshop.service;

import com.lmonkeyshop.dao.Basedao;
import com.lmonkeyshop.entity.LMONKEY_PRODUCT;

/**
 * @title: LMONKEY_PRODUCTDao
 * @Author mazhiwei
 * @Date: 2021/1/30 15:25
 * @Version 1.0
 */
public class LMONKEY_PRODUCTDao {

    public static int insert(LMONKEY_PRODUCT lmonkey_product){
        String sql = "insert into lmonkey_product value(null,?,?,?,?,?,?,?)";
        Object[] prarms={
                lmonkey_product.getPRODUCT_NAME(),
                lmonkey_product.getPRODUCT_DESCRIPTION(),
                lmonkey_product.getPRODUCT_PRICE(),
                lmonkey_product.getPRODUCT_STOCK(),
                lmonkey_product.getPRODUCT_FID(),
                lmonkey_product.getPRODUCT_CID(),
                lmonkey_product.getPRODUCT_FILENAME()
        };
        return Basedao.executeIUD(sql,prarms);
    }

}
