package com.me.test.service;

import com.me.test.pojo.ProductInfo;
import com.me.test.pojo.ShopInfo;

import java.util.List;

public interface ProductInfoService {
    /**
     * 增加一条数据
     * @param productInfo 数据
     */
    void add(ProductInfo productInfo);

    /**
     * 删除一条数据
     * @param id 被删除数据的id
     */
    void delete(Integer id);

    /**
     * 修改一条数据
     * @param productInfo 修改的数据
     */
    void update(ProductInfo productInfo);

    /**
     * 根据id去查询一条数据
     * @param id 查询的id
     */
    ProductInfo queryById(Integer id);

    /**
     * 查询全部数据
     * @return
     */
    List<ProductInfo> queryAll();

    void addNewToShop(ShopInfo shopInfo);
    void updateShopInfo(ShopInfo shopInfo);
    ShopInfo queryShopInfo(int id);
}
