package com.laonog.admin.common.response;


public class BaseResponse {
    /** 结果状态 **/
    private boolean rel;
    /** 返回消息 **/
    private String msg;
    /** 系统状态 **/
    private int status = 200;

    public BaseResponse (boolean error, String msg) {
        this.status = status;
        this.rel = error;
        this.msg = msg;
    }

    public BaseResponse (String msg) {
        this.status = status;
        this.rel = false;
        this.msg = msg;
    }

    public BaseResponse sysmsg(int status, String msg) {
        this.status = status;
        this.rel = false;
        this.msg = msg;
        return this;
    }

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
