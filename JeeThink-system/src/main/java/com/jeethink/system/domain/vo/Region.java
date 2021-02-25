package com.jeethink.system.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class Region {
        Integer regionId;
        String regionName;
        Integer level;
        Integer parentId;
        String regionCode;
        String postCode;
        String diallingCode;
        String shortName;
        String pinyinName;
        String pinyinShortName;
        String mergedName;
        String mergedShortName;
        Double latitude;
        Double longitude;
        Boolean isAvailable;
        Boolean isDeleted;
        Date createTime;
        Date updateTime;
        Boolean operatorType;
        Integer operatorId;
}
