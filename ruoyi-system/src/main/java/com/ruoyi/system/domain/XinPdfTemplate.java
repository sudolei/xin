package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模板文件对象 xin_pdf_template
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public class XinPdfTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 模板名称 */
    @Excel(name = "模板名称")
    private String templateName;

    /** 模板类型 */
    @Excel(name = "模板类型")
    private Long templateType;

    /** 模板路径 */
    @Excel(name = "模板路径")
    private String pdfTemplatePath;

    /** 封面地址 */
    @Excel(name = "封面地址")
    private String pdfTemplateCoverPath;

    /** 图片数量 */
    @Excel(name = "图片数量")
    private Long picNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTemplateName(String templateName) 
    {
        this.templateName = templateName;
    }

    public String getTemplateName() 
    {
        return templateName;
    }
    public void setTemplateType(Long templateType) 
    {
        this.templateType = templateType;
    }

    public Long getTemplateType() 
    {
        return templateType;
    }
    public void setPdfTemplatePath(String pdfTemplatePath) 
    {
        this.pdfTemplatePath = pdfTemplatePath;
    }

    public String getPdfTemplatePath() 
    {
        return pdfTemplatePath;
    }
    public void setPdfTemplateCoverPath(String pdfTemplateCoverPath) 
    {
        this.pdfTemplateCoverPath = pdfTemplateCoverPath;
    }

    public String getPdfTemplateCoverPath() 
    {
        return pdfTemplateCoverPath;
    }
    public void setPicNum(Long picNum) 
    {
        this.picNum = picNum;
    }

    public Long getPicNum() 
    {
        return picNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("templateName", getTemplateName())
            .append("templateType", getTemplateType())
            .append("pdfTemplatePath", getPdfTemplatePath())
            .append("pdfTemplateCoverPath", getPdfTemplateCoverPath())
            .append("picNum", getPicNum())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
