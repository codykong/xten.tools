package com.blog.domain.common;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-18
 * Time: 下午6:39
 * 分页控件
 */
public class Page {

    private final static int DEFAULT_PAGE_SIZE=8;
    private final static int DEFAULT_PAGE_INDEX=1;
    private final static int DEFAULT_TOTAL_NUM=0;
    /**
     * 总记录数
     */
    private int totalNum = DEFAULT_TOTAL_NUM;
    /**
     * 每页记录数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 当前页码
     */
    private int pageIndex = DEFAULT_PAGE_INDEX;
    /**
     * 排序
     */
    private String sort;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public int getTotalPage() {
        return (int) Math.ceil((double)totalNum/pageSize);
    }

    public int getOffset() {
        return (pageIndex - 1) * pageSize;
    }


    public int getTotalNum() {
        return totalNum=totalNum >= 0 ? totalNum : DEFAULT_TOTAL_NUM;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }


    public static final Page getPage(int pageIndex, int pageSize, int totalNum,String sort) {
        Page page = new Page();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalNum(totalNum);
        page.setSort(sort);
        return page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex > 0 ? pageIndex : DEFAULT_PAGE_INDEX;
    }
}
