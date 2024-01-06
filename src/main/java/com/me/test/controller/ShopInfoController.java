package com.me.test.controller;

import com.alibaba.fastjson.JSON;
import com.me.test.pojo.ShopInfoPlusName;
import com.me.test.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@Controller 控制层需要的注解
//@RestController 使用这个也是可以的，但是使用后他里面所有请求返回的都是字符串！
//一般只需要作为接口放回JSON格式数据的话推荐使用@RestController
//@Controller这个是可以与Thymeleaf模板引擎使用时可以返回一个页面的
@Controller
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的
@RequestMapping(value = "/shop")
public class ShopInfoController {
    //获取到UserInfoService
    @Autowired
    private ShopInfoService shopInfoService;

    //Get请求
    @GetMapping
    //@ResponseBody 注释后表示放回的是字符串
    @ResponseBody
    public String queryAll(){
        List<ShopInfoPlusName> shopInfoList = shopInfoService.queryAll();
        return JSON.toJSONString(shopInfoList);
    }

    //使用了RestFull风格
    @GetMapping("/decrease/{id}")
    @ResponseBody
    public String decrease(@PathVariable(value = "id")int id){
          shopInfoService.decrease(id);
          return "购物车商品-1成功";
    }

    //post请求
    //@RequestBody 表示接受请求的JSON格式的数据
    @GetMapping("/increase/{id}")
    @ResponseBody
    public String increase(@PathVariable(value = "id")int id){
        shopInfoService.increase(id);
        return "购物车商品+1成功";
    }
}
