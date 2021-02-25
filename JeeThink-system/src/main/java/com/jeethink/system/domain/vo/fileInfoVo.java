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

    private Long carId;     //二手车id
    private Long creditId;  //征信id
    private Long houseId;   //房产id
    private Long lenderId;  //其他资料id
    private Long visitId;   //家访id
    private Long liushuiId; //流水id

    /** 身份识别码 */
    @Excel(name = "身份识别码")
    private Long userId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

    /**图片list*/
    private String photoFile;

    private String carPhoto;        //二手车list
    private String creditPhoto;     //征信list
    private String housePhoto;      //房产list
    private String lenderPhoto;     //其他资料list
    private String visitPhoto;      //家访list
    private String liushuiPhoto;    //流水list
}
