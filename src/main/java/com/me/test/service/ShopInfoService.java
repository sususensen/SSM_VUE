package com.me.test.service;

import com.me.test.pojo.ShopInfo;
import com.me.test.pojo.ShopInfoPlusName;

import java.util.List;

public interface ShopInfoService {
    List<ShopInfoPlusName> queryAll();
    void decrease(int id);
    void increase(int id);
}
