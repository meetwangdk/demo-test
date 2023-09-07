package com.example.template.common;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable {

    private int status;
    private String resMsg;
    private T data;

    public ServiceResponse() {
    }

    private ServiceResponse(Integer status, String resMsg, T data) {
        this.status = status;
        this.resMsg = resMsg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ServiceResponse<T> resp(CodeType codeType) {
        return resp(codeType, null);
    }

    public static <T> ServiceResponse<T> resp(CodeType codeType, T data) {
        return new ServiceResponse<>(codeType.getStatus(), codeType.getResMsg(), data);
    }

}