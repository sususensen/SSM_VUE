package com.me.test.service.impl;

import com.me.test.mapper.ProductInfoMapper;
import com.me.test.pojo.ProductInfo;
import com.me.test.pojo.ShopInfo;
import com.me.test.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Override
    public void add(ProductInfo productInfo) {
        productInfoMapper.add(productInfo);
    }

    @Override
    public void delete(Integer id) {
        productInfoMapper.delete(id);
    }

    @Override
    public void update(ProductInfo productInfo) {
        productInfoMapper.update(productInfo);
    }

    @Override
    public ProductInfo queryById(Integer id) {
        return productInfoMapper.queryById(id);
    }

    @Override
    public List<ProductInfo> queryAll() {
        return productInfoMapper.queryAll();
    }

    @Override
    public void addNewToShop(ShopInfo shopInfo) { productInfoMapper.addNewToShop(shopInfo);}

    @Override
    public void updateShopInfo(ShopInfo shopInfo) {productInfoMapper.updateShopInfo(shopInfo);}

    @Override
    public ShopInfo queryShopInfo(int id) { return productInfoMapper.queryShopInfo(id);}

}
