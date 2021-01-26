package com.jeethink.system.domain;

import com.jeethink.common.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ZyjrCarType2 {
    private BigDecimal carPrice;

    private Integer carType;

    private String frameNo;

    private String engineNo;

    private String carBrands;

    private String carSeries;

    private String carSpecs;

    private BigDecimal systemCarPrice;

    private String licensePlateNo;
}
