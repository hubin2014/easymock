/*
 * 文 件 名: Stock.java 版 权: Unis Cloud Information Technology Co., Ltd. Copyright
 * 2016, All rights reserved 描 述: <描述> 修 改 人: Administrator 修改时间: 2016-1-7 跟踪单号:
 * <跟踪单号> 修改单号: <修改单号> 修改内容: <修改内容>
 */
package com.hubin.easymock.entity;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author Administrator
 * @version [版本号, 2016-1-7]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class Stock {
    private String name;
    
    private int quantity;
    
    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + quantity;
        return result;
    }
    
    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Stock other = (Stock) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        return true;
    }
    
    /**
     * @return
     */
    @Override
    public String toString() {
        return "Stock [name=" + name + ", quantity=" + quantity + "]";
    }
}
