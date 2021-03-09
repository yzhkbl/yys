package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.ZyjrGrantPhoto;
import lombok.Data;

import java.util.List;
@Data
public class GrantPhoto {
    /** 二手车图片信息表主键 */
    private Long id;

    /** 身份识别码 */
    @Excel(name = "身份识别码")
    private Long userId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /**准入二手车图片信息关联id*/
    //private Long photoCarId;

    /**图片list*/
    private List<ZyjrGrantPhoto> photoFile;
    private List<ZyjrGrantPhoto> icbc;
    private List<ZyjrGrantPhoto> carpic;
}
