/*
 * 文 件 名: SockController.java 版 权: Unis Cloud Information Technology Co., Ltd.
 * Copyright 2016, All rights reserved 描 述: <描述> 修 改 人: Administrator 修改时间:
 * 2016-1-14 跟踪单号: <跟踪单号> 修改单号: <修改单号> 修改内容: <修改内容>
 */
package com.hubin.easymock.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubin.easymock.entity.Stock;
import com.hubin.easymock.service.StockService;

/**
 * @author Administrator
 * @version [版本号, 2016-1-14]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller("stockController")
@RequestMapping("stockController/")
public class StockController {
    @Resource(name = "stockService")
    StockService stockService;
    
    @RequestMapping("getTotalPrice")
    @ResponseBody
    public String getTotalPrice() {
        List<Stock> socketList = stockService.getData();
        double total = stockService.getTotalPrice(socketList);
        return String.valueOf(total);
    }
}
