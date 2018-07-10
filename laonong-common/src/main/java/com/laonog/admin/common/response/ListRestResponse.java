package com.laonog.admin.common.response;

import java.util.List;

public class ListRestResponse<T>{

    /** 数据 **/
    private List<T> data;
    /** 返回消息 **/
    private String msg;

    public ListRestResponse(String msg, List<T> data) {
        this.msg=msg;
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
