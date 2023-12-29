package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XinTemplateType;

/**
 * 模板类型Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public interface XinTemplateTypeMapper 
{
    /**
     * 查询模板类型
     * 
     * @param id 模板类型主键
     * @return 模板类型
     */
    public XinTemplateType selectXinTemplateTypeById(Long id);

    /**
     * 查询模板类型列表
     * 
     * @param xinTemplateType 模板类型
     * @return 模板类型集合
     */
    public List<XinTemplateType> selectXinTemplateTypeList(XinTemplateType xinTemplateType);

    /**
     * 新增模板类型
     * 
     * @param xinTemplateType 模板类型
     * @return 结果
     */
    public int insertXinTemplateType(XinTemplateType xinTemplateType);

    /**
     * 修改模板类型
     * 
     * @param xinTemplateType 模板类型
     * @return 结果
     */
    public int updateXinTemplateType(XinTemplateType xinTemplateType);

    /**
     * 删除模板类型
     * 
     * @param id 模板类型主键
     * @return 结果
     */
    public int deleteXinTemplateTypeById(Long id);

    /**
     * 批量删除模板类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXinTemplateTypeByIds(Long[] ids);
}
