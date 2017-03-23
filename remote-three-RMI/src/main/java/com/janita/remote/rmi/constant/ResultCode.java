package com.janita.remote.rmi.constant;

import java.util.ResourceBundle;

public class ResultCode {

    private static ResourceBundle rb;

    private String code;

    private String message;

    static {
        rb = ResourceBundle.getBundle("messages//error");
    }

    public ResultCode(String code) {
        this.code = code;
        this.message = rb.getString(code);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 未知错误
     */
    public static final ResultCode UNKNOWN = new ResultCode("-1");

    /**
     * 正常操作
     */
    public static final ResultCode SUCCESS = new ResultCode("0");
    
    /**
     * 用户名密码错误
     */
    public static final ResultCode PASSWORD_INCORRECT = new ResultCode("10000");

    /**
     * 登录超时
     */
    public static final ResultCode SESSION_TIME_OUT = new ResultCode("10001");

    /**
     * 未登录
     */
    public static final ResultCode UNLOGIN = new ResultCode("10002");

    /**
     * 请求资源未找到
     */
    public static final ResultCode RESOURCES_NOT_EXIST = new ResultCode("40004");

    /**
     * 资源不能被删除
     */
    public static final ResultCode RESOURCES_NOT_ABLE_DELETE = new ResultCode("40005");

    /**
     * 资源不能被修改
     */
    public static final ResultCode RESOURCES_NOT_ABLE_EDIT = new ResultCode("40006");


    

}
