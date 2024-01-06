package com.me.test.mapper;

import com.me.test.pojo.ProductInfo;
import com.me.test.pojo.ShopInfo;
import com.me.test.pojo.ShopInfoPlusName;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopInfoMapper {
    //获取购物车商品信息
    List<ShopInfoPlusName> queryAll();

    //购物车商品数量增减
    void decrease(int id);
    void increase(int id);

}
