package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模板类型对象 xin_template_type
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public class XinTemplateType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String templateTypeName;

    /** 编码 */
    @Excel(name = "编码")
    private String templateTypeCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTemplateTypeName(String templateTypeName) 
    {
        this.templateTypeName = templateTypeName;
    }

    public String getTemplateTypeName() 
    {
        return templateTypeName;
    }
    public void setTemplateTypeCode(String templateTypeCode) 
    {
        this.templateTypeCode = templateTypeCode;
    }

    public String getTemplateTypeCode() 
    {
        return templateTypeCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("templateTypeName", getTemplateTypeName())
            .append("templateTypeCode", getTemplateTypeCode())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .toString();
    }
}
