package com.laonog.admin.common.response;

import java.util.List;


public class TableResultResponse<T>{

    private TableData<T> data;

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
     * @param msg 提示信息
     * @param total 总数
     * @param rows 数据
     */
    public TableResultResponse(String msg, long total, List<T> rows) {
        this.rel = true;
        this.msg = msg;
        this.data = new TableData<T>(total, rows);
    }

    /**
     * 带系统状态的错误信息返回
     * @param status
     * @param errorCode
     * @param msg
     */
    public TableResultResponse(int status, String errorCode, String msg) {
        this.status = status;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    /**
     * 无业务数据错误信息返回
     * @param errorCode
     * @param msg
     */
    public TableResultResponse(String errorCode, String msg) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> total(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }

    public TableData<T> getData() {
        return data;
    }

    public void setData(TableData<T> data) {
        this.data = data;
    }

    class TableData<T> {
        long total;
        List<T> rows;

        public TableData(long total, List<T> rows) {
            this.total = total;
            this.rows = rows;
        }

        public TableData() {
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }
    }
}
