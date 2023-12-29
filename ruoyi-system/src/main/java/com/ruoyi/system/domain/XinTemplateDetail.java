package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模板详细信息对象 xin_template_detail
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public class XinTemplateDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 模板编号 */
    @Excel(name = "模板编号")
    private Long templateId;

    /** 页数 */
    @Excel(name = "页数")
    private Long pgeNum;

    /** x中心坐标 */
    @Excel(name = "x中心坐标")
    private String xCenterCoord;

    /** y中心坐标 */
    @Excel(name = "y中心坐标")
    private String yCenterCoord;

    /** x开始坐标 */
    @Excel(name = "x开始坐标")
    private String xStartCoord;

    /** y开始坐标 */
    @Excel(name = "y开始坐标")
    private String yStartCoord;

    /** 高度 */
    @Excel(name = "高度")
    private String height;

    /** 宽度 */
    @Excel(name = "宽度")
    private String width;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTemplateId(Long templateId) 
    {
        this.templateId = templateId;
    }

    public Long getTemplateId() 
    {
        return templateId;
    }
    public void setPgeNum(Long pgeNum) 
    {
        this.pgeNum = pgeNum;
    }

    public Long getPgeNum() 
    {
        return pgeNum;
    }
    public void setxCenterCoord(String xCenterCoord) 
    {
        this.xCenterCoord = xCenterCoord;
    }

    public String getxCenterCoord() 
    {
        return xCenterCoord;
    }
    public void setyCenterCoord(String yCenterCoord) 
    {
        this.yCenterCoord = yCenterCoord;
    }

    public String getyCenterCoord() 
    {
        return yCenterCoord;
    }
    public void setxStartCoord(String xStartCoord) 
    {
        this.xStartCoord = xStartCoord;
    }

    public String getxStartCoord() 
    {
        return xStartCoord;
    }
    public void setyStartCoord(String yStartCoord) 
    {
        this.yStartCoord = yStartCoord;
    }

    public String getyStartCoord() 
    {
        return yStartCoord;
    }
    public void setHeight(String height) 
    {
        this.height = height;
    }

    public String getHeight() 
    {
        return height;
    }
    public void setWidth(String width) 
    {
        this.width = width;
    }

    public String getWidth() 
    {
        return width;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("templateId", getTemplateId())
            .append("pgeNum", getPgeNum())
            .append("xCenterCoord", getxCenterCoord())
            .append("yCenterCoord", getyCenterCoord())
            .append("xStartCoord", getxStartCoord())
            .append("yStartCoord", getyStartCoord())
            .append("height", getHeight())
            .append("width", getWidth())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
