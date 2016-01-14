/*
 * 文 件 名: PortfolioTest.java 版 权: Unis Cloud Information Technology Co., Ltd.
 * Copyright 2016, All rights reserved 描 述: <描述> 修 改 人: Administrator 修改时间:
 * 2016-1-7 跟踪单号: <跟踪单号> 修改单号: <修改单号> 修改内容: <修改内容>
 */
package com.hubin.easymock.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.hubin.easymock.dao.StockMarket;
import com.hubin.easymock.entity.Stock;

public class StockServiceTest {
    private StockService socketService = null;
    
    private StockMarket stockMarket = null;
    
    @Before
    public void initUp() {
        stockMarket = EasyMock.createMock(StockMarket.class);
        socketService = new StockService();
        // 篡改真实的环境中的stockMarket
        socketService.stockMarket = stockMarket;
    }
    
    public List<Stock> buildDate() {
        List<Stock> list = new ArrayList<Stock>();
        Stock stock1 = new Stock("unis", 200);
        Stock stock2 = new Stock("alibaba", 100);
        list.add(stock1);
        list.add(stock2);
        return list;
    }
    
    /**
     * 通过easymock进行模拟测试
     * 
     * @return void [返回类型说明]
     * @exception throws [违例类型] [违例说明]
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void testGetTotalPrice() {
        EasyMock.expect(stockMarket.getPrice("unis"))
                .andReturn(10.00)
                .times(1, 2);
        EasyMock.expect(stockMarket.getPrice("alibaba"))
                .andReturn(100.00)
                .times(1, 2);
        EasyMock.replay(stockMarket);
        double total = socketService.getTotalPrice(buildDate());
        System.out.println(total);
    }
    
    @Test
    public void testGetData() {
        EasyMock.expect(stockMarket.buildDate())
                .andReturn(buildDate())
                .times(1, 2);
        EasyMock.replay(stockMarket);
        assertEquals(true, socketService.getData().size() == 2);
    }
}
