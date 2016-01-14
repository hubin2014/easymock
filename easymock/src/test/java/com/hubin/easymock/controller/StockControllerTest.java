/*
 * 文 件 名: StockControllerTest.java 版 权: Unis Cloud Information Technology Co.,
 * Ltd. Copyright 2016, All rights reserved 描 述: <描述> 修 改 人: Administrator 修改时间:
 * 2016-1-14 跟踪单号: <跟踪单号> 修改单号: <修改单号> 修改内容: <修改内容>
 */
package com.hubin.easymock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.hubin.easymock.entity.Stock;
import com.hubin.easymock.service.StockService;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Administrator
 * @version [版本号, 2016-1-14]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/easymockServlet.xml" })
public class StockControllerTest {
    @Autowired
    private WebApplicationContext wac;
    
    private StockService stockService = null;
    
    @Resource(name = "stockController")
    private StockController stockController;
    
    private MockMvc mockMvc;
    
    @Before
    public void intUp() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        stockService = EasyMock.createMock(StockService.class);
        // 篡改真实的环境中的StockService
        stockController.stockService = stockService;
    }
    
    public List<Stock> buildDate() {
        List<Stock> list = new ArrayList<Stock>();
        Stock stock1 = new Stock("unis", 200);
        Stock stock2 = new Stock("alibaba", 100);
        list.add(stock1);
        list.add(stock2);
        return list;
    }
    
    @Test
    public void testGetTotalPrice() throws Exception {
        EasyMock.expect(stockService.getData())
                .andReturn(buildDate())
                .times(1, 3);
        EasyMock.expect(stockService.getTotalPrice(buildDate()))
                .andReturn(300.00)
                .times(1, 3);
        EasyMock.replay(stockService);
        mockMvc.perform((get("/stockController/getTotalPrice.htm")));
    }
}
