package com.jeethink.system.base.controller;

public enum ResultCodeEnum implements IResultCode {
    SUCCESS("0000", "成功"),

    ERROR_NO_LOGIN("1000", "用户尚未登录，请先登录"),
    ERROR_NO_LOGIN_NAME("1001", "登录账户不存在"),
    ERROR_USER_PWD("1002", "登录密码错误"),
    ERROR_USER_DISABLE("1003", "账号已被停用"),
    ERROR_USER_FREEZE("1004", "账号已被冻结"),
    ERROR_VALIDATE_TOKEN("1005", "用户登录信息已失效,请重新登录"),
    ERROR_NO_USER_INFO("1006", "用户信息不存在"),
    ERROR_NO_PERMISSION("1007", "没有访问权限"),

    ERROR_KAPTCHA_FAILURE("1008", "验证码已失效"),
    ERROR_KAPTCHA_WRONG("1009", "验证码错误"),

    ERROR_SAVE_FAIL("2001", "保存信息失败"),
    ERROR_DELETE_FAIL("2002", "删除信息失败"),
    ERROR_UPDATE_FAIL("2003", "更新信息失败"),
    ERROR_QUERY_NO_RESULT_FAIL("2004", "查询无结果"),
    ERROR_QUERY_RESULT_LARGER_FAIL("2005", "查询结果集过大"),
    ERROR_VALIDATE_FAIL("2006", "数据验证失败"),
    ERROR_BUSINESS_FAIL("2999", "业务操作失败"),


    ERROR_FILE_UPLOAD_FAIL("3001", "文件上传失败"),
    ERROR_FILE_DOWNLOAD_FAIL("3002", "文件下载失败"),



    ERROR_WORKFLOW_DEPLOY_EXCEPTION("4000", "工作流模型部署异常"),


    ERROR_SYSTEM_EXCEPTION("9000", "系统异常"),
    ERROR_RUNTIME_EXCEPTION("9001", "系统运行异常"),
    ERROR_NULLPOINTER_EXCEPTION("9002", "系统空指针异常"),
    ERROR_CLASSCAST_EXCEPTION("9003", "系统类型转换异常"),
    ERROR_IO_EXCEPTION("9004", "系统IO异常"),
    ERROR_NOSUCHMETHOD_EXCEPTION("9005", "系统未知方法异常"),
    ERROR_INDEXOUTOFBOUNDS_EXCEPTION("9006", "数组越界异常"),
    ERROR_PARSE_EXCEPTION("9007", "数据格式异常"),
    ERROR_CREATE_TRANSACTION_EXCEPTION("9008", "数据格式异常"),
    ERROR_LOGIN_EXCEPTION("9009", "用户登录发生异常");

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 编码
     */
    private String code;
    /**
     * 描述
     */
    private String message;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
