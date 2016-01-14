/*
 * 文 件 名: StockMarket.java 版 权: Unis Cloud Information Technology Co., Ltd.
 * Copyright 2016, All rights reserved 描 述: <描述> 修 改 人: Administrator 修改时间:
 * 2016-1-7 跟踪单号: <跟踪单号> 修改单号: <修改单号> 修改内容: <修改内容>
 */
package com.hubin.easymock.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hubin.easymock.entity.Stock;

/**
 * @author Administrator
 * @version [版本号, 2016-1-7]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Repository("stockMarket")
public class StockMarket {
    public Double getPrice(String stockName) {
        double price = 0.00;
        if ("unis".equals(stockName)) {
            price = 63.50;
        }
        else if ("alibaba".equals(stockName)) {
            price = 1000.00;
        }
        return price;
    }
    
    public List<Stock> buildDate() {
        List<Stock> list = new ArrayList<Stock>();
        Stock stock1 = new Stock("unis", 200);
        Stock stock2 = new Stock("alibaba", 100);
        list.add(stock1);
        list.add(stock2);
        return list;
    }
    
    public Double getRate(String stockName) throws ArithmeticException {
        double rate = 0.00;
        if ("unis".equals(stockName)) {
            rate = getPrice(stockName) / 0;
        }
        else if ("alibaba".equals(stockName)) {
            rate = getPrice(stockName) / 100;
        }
        return rate;
    }
}
