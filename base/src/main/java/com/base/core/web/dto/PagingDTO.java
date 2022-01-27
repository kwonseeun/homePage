package com.base.core.web.dto;

/**
 * [공통] Paging DTO
 * @author joys
 *
 */
public class PagingDTO {

	/** 선택 Page 번호 */
	private int currentPage = 1;
	/** 선택 Page Size */
	private int pageSize = 5;
	
	private int totalCount = 0;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


}
