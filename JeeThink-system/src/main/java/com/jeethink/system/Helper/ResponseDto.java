package com.jeethink.system.Helper;

import lombok.Data;

@Data
public class ResponseDto<T> {
    /**
     * 未知错误
     */
    public static final int ERROR_SYS = -1;
    /**
     * 成功
     */
    public static final int SUCCESS = 0;
    /**
     * 业务失败
     */
    public static final int FAIL_BIZ = 1;
    /**
     * 会话失败
     */
    public static final int FAIL_AUTH_SESSION = 2;
    /**
     * 需升级客户端
     */
    public static final int FAIL_UPGRADE = 3;
    /**
     * 鉴权失败
     */
    public static final int FAIL_AUTH = 4;
    /**
     * 未绑定手机号
     */
    public static final int UNBIND_PHONE = 5;
    /**
     * 未初始化密码
     */
    public static final int UNINITIALIZED_PWD = 6;

    /**
     * 签约验证失败
     */
    public static final int SIGN_AUTH_FAIL=7;

    /**
     * 访问被删除的机构或已不是该机构成员
     */
    public static final int ACCESS_DELETED_BUSINESS=8;

    private int code = SUCCESS;
    private T data;
    private String msg;


    public ResponseDto() {

    }

    public ResponseDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseDto(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回执行成功结果
     *
     * @return
     */
    public static ResponseDto success() {
        return new ResponseDto();
    }

    /**
     * 返回执行成功结果
     *
     * @param msg 执行后的消息
     * @return
     */
    public static ResponseDto success(String msg) {
        ResponseDto result = new ResponseDto();
        result.setMsg(msg);

        return result;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回执行成功结果
     *
     * @param data 返回的具体业务内容
     * @return
     */
    public static <T> ResponseDto<T> success(T data) {
        return success(null, data);
    }


    /**
     * 返回执行成功结果
     *
     * @param msg  执行后的消息
     * @param data 返回的具体业务内容
     * @return
     */
    public static <T> ResponseDto<T> success(String msg, T data) {
        ResponseDto result = new ResponseDto();
        result.setMsg(msg);
        result.setData(data);

        return result;
    }

    private void setData(T data) {
        this.data = data;
    }

    /**
     * @param status
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseDto<T> success(int status, String msg) {
        ResponseDto result = new ResponseDto();
        result.setMsg(msg);
        result.setCode(status);

        return result;
    }

    private void setCode(int status) {
        this.code = code;
    }

    /**
     * 返回执行成功结果
     *
     * @param status
     * @param msg    执行后的消息
     * @param data   返回的具体业务内容
     * @return
     */
    public static <T> ResponseDto<T> success(int status, String msg, T data) {
        ResponseDto result = new ResponseDto();
        result.setCode(status);
        result.setMsg(msg);
        result.setData(data);

        return result;
    }

    /**
     * 返回执行失败结果
     *
     * @return
     */
    public static ResponseDto fail() {
        ResponseDto result = new ResponseDto();
        result.setCode(FAIL_BIZ);

        return result;
    }

    /**
     * 返回执行失败结果
     *
     * @param msg 执行后的消息
     * @return
     */
    public static ResponseDto fail(String msg) {
        ResponseDto result = new ResponseDto();
        result.setMsg(msg);
        result.setCode(FAIL_BIZ);

        return result;
    }

    /**
     * 返回执行失败结果
     *
     * @param data 返回的具体业务内容
     * @return
     */
    public static <T> ResponseDto<T> fail(T data) {
        ResponseDto result = new ResponseDto();
        result.setData(data);
        result.setCode(FAIL_BIZ);

        return result;
    }

    /**
     * 返回执行失败结果
     *
     * @param msg  执行后的消息
     * @param data 返回的具体业务内容
     * @return
     */
    public static <T> ResponseDto<T> fail(String msg, T data) {
        return new ResponseDto(FAIL_BIZ, msg, data);
    }

    /**
     * 返回执行失败结果
     *
     * @param status
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseDto<T> fail(int status, String msg) {
        return new ResponseDto(status, msg, null);
    }

    /**
     * 返回执行失败结果
     *
     * @param status
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseDto<T> fail(int status, T data) {
        return new ResponseDto(status, null, data);
    }

    /**
     * 返回执行失败结果
     *
     * @param status 执行状态
     * @param msg    执行后的消息
     * @param data   返回的具体业务内容
     * @return
     */
    public static <T> ResponseDto<T> fail(int status, String msg, T data) {
        return new ResponseDto(status, msg, data);
    }

}
