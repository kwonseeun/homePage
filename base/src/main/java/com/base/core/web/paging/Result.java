package com.base.core.web.paging;

import java.util.List;

/**
 *
 * 업무명 : 공통
 * 설명 : 리스트 페이지에서 사용될 정보를 담은 VO
 * 작성자 : CelestialMoon
 * 작성일 : 2010. 6. 1.
 *
 * 수정일			수정자				수정내용
 * ---------------------------------------------------
 *
 */
public class Result
{
	private PageNavigator navigator;
	private List<?> list;

	public Result(List<?> list, PageNavigator navigator)
	{
		this.list = list;
		this.navigator = navigator;
	}

	/**
	 * @return the navigator
	 */
	public PageNavigator getNavigator() {
		return navigator;
	}

	/**
	 * @param navigator the navigator to set
	 */
	public void setNavigator(PageNavigator navigator) {
		this.navigator = navigator;
	}

	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<?> list) {
		this.list = list;
	}
}