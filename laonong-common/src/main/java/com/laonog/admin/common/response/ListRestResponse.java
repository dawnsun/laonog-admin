package com.laonog.admin.common.response;

import java.util.List;

public class ListRestResponse<T>{

    /** 数据 **/
    private List<T> data;
    /** 返回消息 **/
    private String msg;
    /** 结果状态 **/
    private boolean rel = false;
    /** 错误编码 */
    private String errorCode ;
    /** 系统状态 **/
    private int status = 200;

    /**
     * 正确状态数据返回
     * @param msg
     * @param data
     */
    public ListRestResponse(String msg, List<T> data) {
        this.rel = true;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无业务数据错误信息返回
     * @param errorCode
     * @param msg
     */
    public ListRestResponse(String errorCode, String msg) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    /**
     * 带系统状态的错误信息返回
     * @param status
     * @param errorCode
     * @param msg
     */
    public ListRestResponse(int status, String errorCode, String msg) {
        this.status = status;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    /**
     * 带业务数据的错误信息返回
     * @param errorCode
     * @param msg
     * @param data
     */
    public ListRestResponse(String errorCode, String msg, List<T> data) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
