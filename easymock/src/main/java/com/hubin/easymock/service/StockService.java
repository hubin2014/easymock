/*
 * 文 件 名: Portfolio.java 版 权: Unis Cloud Information Technology Co., Ltd.
 * Copyright 2016, All rights reserved 描 述: <描述> 修 改 人: Administrator 修改时间:
 * 2016-1-7 跟踪单号: <跟踪单号> 修改单号: <修改单号> 修改内容: <修改内容>
 */
package com.hubin.easymock.service;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Administrator
 * @version [版本号, 2016-1-7]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hubin.easymock.dao.StockMarket;
import com.hubin.easymock.entity.Stock;

@Service("stockService")
public class StockService {
    @Resource(name = "stockMarket")
    public StockMarket stockMarket;
    
    /**
     * @param 对stockMarket进行赋值
     */
    public void setStockMarket(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }
    
    /**
     * @return [参数说明]
     * @return double [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    public double getTotalPrice(List<Stock> stockList) {
        double totalPrice = 0.00;
        for (Stock stock : stockList) {
            totalPrice += stockMarket.getPrice(stock.getName())
                    * stock.getQuantity();
        }
        return totalPrice;
    }
    
    public List<Stock> getData() {
        return stockMarket.buildDate();
    }
}