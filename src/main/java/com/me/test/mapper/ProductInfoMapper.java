package com.me.test.mapper;

import com.me.test.pojo.ProductInfo;
import com.me.test.pojo.ShopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductInfoMapper {
    //增删改查
    void add(ProductInfo productInfo);
    void delete(int id);
    void update(ProductInfo productInfo);
    ProductInfo queryById(int id);

    //查询所有
    List<ProductInfo> queryAll();

    //根据购物车是否有商品来判断加入购物车是新建还是增加
    void addNewToShop(ShopInfo shopInfo);
    void updateShopInfo(ShopInfo shopInfo);

    //判断购物车表是否有该商品
    ShopInfo queryShopInfo(int id);
}
