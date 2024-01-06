package com.me.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//使用@Data自动生成需要的get、set
@Data
//使用@AllArgsConstructor自动生成有参构造
@AllArgsConstructor
//使用@NoArgsConstructor自动生成无参构造
@NoArgsConstructor
public class ShopInfoPlusName {
    private int shopID;
    private int productID;
    private String productName;
    private int count;
    private double totalCost;
    private String describe;
}
