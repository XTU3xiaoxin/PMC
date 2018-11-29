package com.bcs.tja.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;  
/**
 * @ClassName: DynamicDataSource.java
 * @Description: 多数据源
 * @author XCH
 * @date 2018年5月9日 上午10:07:10
 */
public class DynamicDataSource extends AbstractRoutingDataSource {  
	
    @Override  
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDbType();
    }  
}  