package com.jeethink.system.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class MateAdded {
    Integer taskId;
    List<Mates> mates;
}
