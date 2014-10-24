package com.blog.domain.vo.blog;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-9-18
 * Time: 下午6:16
 * To change this template use File | Settings | File Templates.
 */
public class BlogPrevQueVO {

    /**
     * 查询起始位置
     */
    private int offset;
    /**
     * 显示行数
     */
    private int size;
    /**
     * 当前页码
     */
    private int pageIndex;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {

        if(offset == 0){
            return (getSize()*(getPageIndex()-1));
        }else {
            return offset;
        }

    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
