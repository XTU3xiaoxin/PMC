package com.bcs.tja.utils;

/**
 * @ClassName: DataSourceContextHolder.java
 * @Description: 多数据源
 * @author XCH
 * @date 2018年5月9日 上午10:07:24
 */
public class DataSourceContextHolder {  
	
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
    
    public static void setDbType(String dbType) {  
        contextHolder.set(dbType);  
    }  
    public static String getDbType() {  
        return (contextHolder.get());  
    }  
    public static void clearDbType() {  
        contextHolder.remove();  
    }  
}  