package com.laonog.admin.common.query;

import com.laonog.admin.common.constant.CommonConstants;

public class BaseQuery {


    /**
     * 默认每页条数
     */
    public static final int DEFAULT_OFFSET = 0;

    /**
     * 当前页码
     */
    private int pageNo;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 起始行标
     */
    private int offset;

    /**
     * 构造函数
     */
    public BaseQuery() {
        pageNo = CommonConstants.DEFAULT_PAGE_NO;
        pageSize = CommonConstants.DEFAULT_PAGE_SIZE;
        offset = DEFAULT_OFFSET;
    }

    /**
     * 构造函数
     */
    public BaseQuery(int pageNo,int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        offset = (pageNo-1)*pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
