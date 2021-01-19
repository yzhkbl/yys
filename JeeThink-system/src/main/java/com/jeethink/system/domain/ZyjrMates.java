package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * mates对象 zyjr_mates
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public class ZyjrMates extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long demandMateId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String materiaIsPic;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String fileName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String zyjrMaterialsId;

    public void setDemandMateId(Long demandMateId) 
    {
        this.demandMateId = demandMateId;
    }

    public Long getDemandMateId() 
    {
        return demandMateId;
    }
    public void setMateriaIsPic(String materiaIsPic) 
    {
        this.materiaIsPic = materiaIsPic;
    }

    public String getMateriaIsPic() 
    {
        return materiaIsPic;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setZyjrMaterialsId(String zyjrMaterialsId) 
    {
        this.zyjrMaterialsId = zyjrMaterialsId;
    }

    public String getZyjrMaterialsId() 
    {
        return zyjrMaterialsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("demandMateId", getDemandMateId())
            .append("materiaIsPic", getMateriaIsPic())
            .append("fileName", getFileName())
            .append("zyjrMaterialsId", getZyjrMaterialsId())
            .toString();
    }
}
