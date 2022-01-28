package com.base.core.web.paging;

/**
 * 
 * 업무명 : 공통
 * 설명 : 리스트 페이지의 Page Navigator를 생성하기 위한 정보를 담고 있는 VO
 * 작성자 : CelestialMoon
 * 작성일 : 2010. 6. 1.
 *
 * 수정일			수정자				수정내용
 * ---------------------------------------------------
 *
 */

public class PageNavigator
{

    public static int PAGESIZE = 1;   //NOPMD
   // public static int PAGEUNIT = 10;
    public static int PAGEUNIT = 10;  //NOPMD

    private int currentPageIndex = 0;
    private int totalCount = 0;
    private int lastPage = 0;
    private int startPageUnit = 0;
    private int endPageUnit = 0;

    private int previousPageNumber = 0;
    private int nextPageNumber = 0;

    public PageNavigator (int currentPageIndex, int pageSize, int totalCount)
    {
        this(currentPageIndex, pageSize, PageNavigator.PAGEUNIT, totalCount);
    }

    public PageNavigator (int currentPageIndex, int totalCount)
    {
        this(currentPageIndex, PageNavigator.PAGESIZE, PageNavigator.PAGEUNIT, totalCount);
    }

    public PageNavigator (int currentPageIndex, int pageSize, int pageUnit, int totalCount)
    {
        this.totalCount = totalCount;

        if (pageSize != -1 && pageUnit != -1 && currentPageIndex != -1)
        {
            this.currentPageIndex = currentPageIndex;
            this.lastPage = (totalCount - 1) / pageSize + 1;
            this.startPageUnit = ((currentPageIndex - 1) / pageUnit) * pageUnit - 1;
            this.endPageUnit = this.startPageUnit + (pageUnit - 1);

            PageNavigator.PAGESIZE = pageSize;
            PageNavigator.PAGEUNIT = pageUnit;
        }
    }

    /**
     * @return Returns the pageSize.
     */
    public int getPageSize() {
        return PageNavigator.PAGESIZE;
    }

    /**
     * @param pageSize The pageSize to set.
     */
    public void setPageSize(int pageSize) {
        PageNavigator.PAGESIZE = pageSize;
    }

    /**
     * @return Returns the pageUnit.
     */
    public int getPageUnit() {
        return PageNavigator.PAGEUNIT;
    }

    /**
     * @param pageUnit The pageUnit to set.
     */
    public void setPageUnit(int pageUnit) {
        PageNavigator.PAGEUNIT = pageUnit;
    }

    /**
     * @return Returns the currentPageIndex.
     */
    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    /**
     * @param currentPageIndex The currentPageIndex to set.
     */
    public void setCurrentPageIndex(int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    /**
     * @return Returns the totalCount.
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount The totalCount to set.
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return Returns the lastPage.
     */
    public int getLastPage() {
        return lastPage;
    }

    /**
     * @param lastPage The lastPage to set.
     */
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * @return Returns the startPageUnit.
     */
    public int getStartPageUnit() {
        return startPageUnit;
    }

    /**
     * @param startPageUnit The startPageUnit to set.
     */
    public void setStartPageUnit(int startPageUnit) {
        this.startPageUnit = startPageUnit;
    }
    
    /**
     * @return Returns the endPageUnit.
     */
    public int getEndPageUnit() {
        return endPageUnit;
    }

    /**
     * @param endPageUnit The endPageUnit to set.
     */
    public void setEndPageUnit(int endPageUnit) {
        this.endPageUnit = endPageUnit;
    }

    /**
     * @return
     */
    public int getPreviousPageNumber()
    {
        this.previousPageNumber = ((this.currentPageIndex - 1) / PageNavigator.PAGEUNIT) * PageNavigator.PAGEUNIT;
        return this.previousPageNumber;
    }

    /**
     * @return
     */
    public int getNextPageNumber()
    {
        this.nextPageNumber = this.previousPageNumber + PageNavigator.PAGEUNIT + 1;
        if (this.nextPageNumber > this.lastPage) this.nextPageNumber = this.lastPage + 1;
        return this.nextPageNumber;
    }

    /**
     * @return
     */
    public int getStartPageNumber()
    {
        return this.previousPageNumber + 1;
    }

    /**
     * @return
     */
    public int getLastPageNumber()
    {
        return this.nextPageNumber - 1;
    }
}