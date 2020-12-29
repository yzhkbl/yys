package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import com.jeethink.system.domain.SysFileInfo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class fileInfoVo {

    /** 二手车图片信息表主键 */
    private Long id;

    /** 身份识别码 */
    @Excel(name = "身份识别码")
    private Long userId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

    /**准入二手车图片信息关联id*/
    //private Long photoCarId;

    /**图片list*/
    private List<SysFileInfo> photoFile;
}
