package com.zyj.plaything.pojo;

/**
 * 服务器返回值基类
 * Created by Jing on 2016/5/24.
 */
public class ServiceResult<T> {
    private String resultcode;

    private String reason;

    private T result;

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getResultcode() {
        return this.resultcode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getResult() {
        return this.result;
    }
}
