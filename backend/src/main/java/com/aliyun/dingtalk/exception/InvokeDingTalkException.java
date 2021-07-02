package com.aliyun.dingtalk.exception;

/**
 * 调用钉钉接口异常时抛出该异常
 */
public class InvokeDingTalkException extends RuntimeException {
    private static final long serialVersionUID = -238091758285157331L;
    private String errCode;
    private String errMsg;
    private String subErrCode;
    private String subErrMsg;

    public String getSubErrCode() {
        return this.subErrCode;
    }

    public void setSubErrCode(String subErrCode) {
        this.subErrCode = subErrCode;
    }

    public String getSubErrMsg() {
        return this.subErrMsg;
    }

    public void setSubErrMsg(String subErrMsg) {
        this.subErrMsg = subErrMsg;
    }

    public InvokeDingTalkException() {
    }

    public InvokeDingTalkException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvokeDingTalkException(String message) {
        super(message);
    }

    public InvokeDingTalkException(Throwable cause) {
        super(cause);
    }

    public InvokeDingTalkException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public InvokeDingTalkException(String errCode, String errMsg, String subErrCode, String subErrMsg) {
        super(errCode + ":" + errMsg + ":" + subErrCode + ":" + subErrMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.subErrCode = subErrCode;
        this.subErrMsg = subErrMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}
