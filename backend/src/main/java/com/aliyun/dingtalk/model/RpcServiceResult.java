package com.aliyun.dingtalk.model;

/**
 * RPC服务返回结果
 */
public class RpcServiceResult<T> {

    private boolean success;

    private String errorCode;

    private String errorMsg;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> RpcServiceResult<T> getSuccessResult(T t) {
        RpcServiceResult<T> result = new RpcServiceResult<>();
        result.setSuccess(true);
        result.setData(t);

        return result;
    }

    public static <T> RpcServiceResult<T> getFailureResult(String code, String msg) {
        RpcServiceResult<T> result = new RpcServiceResult<>();
        result.setSuccess(false);
        result.setErrorCode(code);
        result.setErrorMsg(msg);

        return result;
    }
}
