package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import lombok.Data;

@Data
public class carVo {
    private Long id;
    /**所属区域**/
    private String area;

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
}
