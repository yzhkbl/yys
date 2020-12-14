package com.jeethink.system.domain;

import lombok.Data;

@Data
public class StartPage {
    private Integer id;

    private String fundSide;

    private String businessPlace;

    private Boolean orderState;

    private Integer userId;
}
