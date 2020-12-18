package com.jeethink.system.base.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultData<T> implements Serializable {
    @ApiModelProperty(value = "响应编码")
    private String code;

    @ApiModelProperty(value = "响应信息")
    private String message;

    @ApiModelProperty(value = "响应详细信息")
    private String details;

    @ApiModelProperty(value = "响应业务数据")
    private T data;

    public boolean isSuccess() {
        return  ResultCodeEnum.SUCCESS.getCode().equals(this.code);
    }

}
