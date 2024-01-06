package com.me.test.service.impl;

import com.me.test.mapper.ShopInfoMapper;
import com.me.test.pojo.ShopInfo;
import com.me.test.pojo.ShopInfoPlusName;
import com.me.test.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopInfoServiceImpl implements ShopInfoService {
    @Autowired
    private ShopInfoMapper shopInfoMapper;
    @Override
    public List<ShopInfoPlusName> queryAll() {
        return shopInfoMapper.queryAll();
    }

    @Override
    public void decrease(int id) {
        shopInfoMapper.decrease(id);
    }

    @Override
    public void increase(int id) {
         shopInfoMapper.increase(id);
    }
}
