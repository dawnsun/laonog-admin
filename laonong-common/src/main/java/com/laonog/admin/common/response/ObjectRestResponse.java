package com.laonog.admin.common.response;


public class ObjectRestResponse<T> {

    /** 数据 **/
    private T data;
    /** 返回消息 **/
    private String msg;

    public ObjectRestResponse(String msg, T data) {
        this.msg=msg;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
