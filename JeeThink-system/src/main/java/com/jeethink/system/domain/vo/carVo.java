package com.jeethink.system.domain.vo;

import lombok.Data;

@Data
public class carVo {
    private Long id;
    /**所属区域**/
    private String area;

    private String city;


    /** 所属市场 */
    private String bazaar;
    /**
     * 状态
     */
    private String state;
    /**
     * 车商名称
     */
    private String dealerName;
    private String shopType;
}
