package com.jeethink.system.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class Materials {
    String materialCode;
    String materialsType;
    String downloadMode;
    List<MatesVo> mates;
}
