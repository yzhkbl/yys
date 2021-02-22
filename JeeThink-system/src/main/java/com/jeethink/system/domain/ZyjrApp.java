package com.jeethink.system.domain;

import lombok.Data;

@Data
public class ZyjrApp {
    private Long id;
    private Integer versionCode;    //内部版本号
    private String downloadUrl;     //app下载地址
    private String name;            //app版本名称
    private String content;         //版本描述
}
