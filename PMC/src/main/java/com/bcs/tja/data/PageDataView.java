package com.bcs.tja.data;

import java.util.List;

/**
* @ClassName: PageDataView
* @Description: 分页信息
 */
public class PageDataView<T> {
	
	private int total;
	
	private List<T> rows;

	public PageDataView() {
		super();
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
