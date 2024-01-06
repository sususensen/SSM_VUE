package com.me.test.controller;

import com.alibaba.fastjson.JSON;
import com.me.test.pojo.ProductInfo;
import com.me.test.pojo.ShopInfo;
import com.me.test.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//@Controller 控制层需要的注解
//@RestController 使用这个也是可以的，但是使用后他里面所有请求返回的都是字符串！
//一般只需要作为接口放回JSON格式数据的话推荐使用@RestController
//@Controller这个是可以与Thymeleaf模板引擎使用时可以返回一个页面的
@Controller
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的
@RequestMapping(value = "/product")
public class ProductInfoController {
    //获取到UserInfoService
    @Autowired
    private ProductInfoService productInfoService;

    //Get请求
    @GetMapping
    //@ResponseBody 注释后表示放回的是字符串
    @ResponseBody
    public String queryAll(){
        List<ProductInfo> productInfoList = productInfoService.queryAll();
        return JSON.toJSONString(productInfoList);
    }

    //使用了RestFull风格
    @GetMapping("/{id}")
    @ResponseBody
    public String query(@PathVariable(value = "id")int id){
        ProductInfo productInfo = productInfoService.queryById(id);
        List<ProductInfo> productInfoList = new ArrayList<>();
        productInfoList.add(productInfo);
        return JSON.toJSONString(productInfoList);
    }

    //post请求
    //@RequestBody 表示接受请求的JSON格式的数据
    @PostMapping
    @ResponseBody
    public String add(@RequestBody ProductInfo productInfo){
        productInfoService.add(productInfo);
        return "添加OK";
    }

    //Delete请求
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")int id){
        productInfoService.delete(id);
        return "删除成功";
    }

    //Put请求
    @PutMapping
    @ResponseBody
    public String update(
            @RequestBody ProductInfo productInfo){
        productInfoService.update(productInfo);
        return "修改成功";
    }

    @PostMapping("/shop")
    @ResponseBody
    public String addToShop(@RequestBody Map<Integer,Integer> map){
        for(Object key : map.keySet()){
            int count= map.get(key);
            ShopInfo shopInfo = productInfoService.queryShopInfo((int) key);
            ProductInfo productInfo = productInfoService.queryById((int)key);
            if(shopInfo != null){
                shopInfo.setCount(shopInfo.getCount()+count);
                shopInfo.setTotalCost(productInfo.getPrice()*shopInfo.getCount());
                productInfoService.updateShopInfo(shopInfo);
                productInfo.setNumber(productInfo.getNumber()-count);
                productInfoService.update(productInfo);
            }
            else{
                shopInfo = new ShopInfo();
                shopInfo.setProductID((int) key);
                shopInfo.setCount(count);
                shopInfo.setTotalCost(productInfo.getPrice()*count);
                productInfoService.addNewToShop(shopInfo);
                productInfo.setNumber(productInfo.getNumber()-count);
                productInfoService.update(productInfo);
            }
        }

        return "添加购物车成功";
    }
}
