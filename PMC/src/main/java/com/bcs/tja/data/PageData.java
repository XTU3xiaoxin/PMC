package com.bcs.tja.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* @ClassName: PageData
* @Description: 分页信息
 */
public class PageData<T> implements Serializable{
	
	private static final long serialVersionUID = -6599763649109654292L;
	
	/** 每页显示记录数 */
	private int pageSize = 10;
	/** 当前页 */
	private int currentPage = 1;
	/** 总记录数 */
	private long totalRecord;
	/** 当前从多少条开始 */
	private int startPage;
	/** 共有多少页 */
	private long pageNumShown;
	
	private int total;
	
	private List<T> rows = new ArrayList<T>();

	public PageData() {
		super();
	}

	public PageData(int currrentPage, int pageSize) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currrentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize == 0?10:pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStartPage() {
		if (currentPage == 1) {
			startPage = 0;
		} else {
			startPage = (currentPage - 1) * pageSize;
		}
		return startPage;
	}

	public long getPageNumShown() {
		pageNumShown = (totalRecord / pageSize) + (totalRecord % pageSize > 0 ? 1 : 0);
		return pageNumShown;
	}

	public void setPageNumShown(long pageNumShown) {
		this.pageNumShown = pageNumShown;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
