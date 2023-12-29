package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XinTemplateTypeMapper;
import com.ruoyi.system.domain.XinTemplateType;
import com.ruoyi.system.service.IXinTemplateTypeService;

/**
 * 模板类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Service
public class XinTemplateTypeServiceImpl implements IXinTemplateTypeService 
{
    @Autowired
    private XinTemplateTypeMapper xinTemplateTypeMapper;

    /**
     * 查询模板类型
     * 
     * @param id 模板类型主键
     * @return 模板类型
     */
    @Override
    public XinTemplateType selectXinTemplateTypeById(Long id)
    {
        return xinTemplateTypeMapper.selectXinTemplateTypeById(id);
    }

    /**
     * 查询模板类型列表
     * 
     * @param xinTemplateType 模板类型
     * @return 模板类型
     */
    @Override
    public List<XinTemplateType> selectXinTemplateTypeList(XinTemplateType xinTemplateType)
    {
        return xinTemplateTypeMapper.selectXinTemplateTypeList(xinTemplateType);
    }

    /**
     * 新增模板类型
     * 
     * @param xinTemplateType 模板类型
     * @return 结果
     */
    @Override
    public int insertXinTemplateType(XinTemplateType xinTemplateType)
    {
        xinTemplateType.setCreateTime(DateUtils.getNowDate());
        return xinTemplateTypeMapper.insertXinTemplateType(xinTemplateType);
    }

    /**
     * 修改模板类型
     * 
     * @param xinTemplateType 模板类型
     * @return 结果
     */
    @Override
    public int updateXinTemplateType(XinTemplateType xinTemplateType)
    {
        xinTemplateType.setUpdateTime(DateUtils.getNowDate());
        return xinTemplateTypeMapper.updateXinTemplateType(xinTemplateType);
    }

    /**
     * 批量删除模板类型
     * 
     * @param ids 需要删除的模板类型主键
     * @return 结果
     */
    @Override
    public int deleteXinTemplateTypeByIds(Long[] ids)
    {
        return xinTemplateTypeMapper.deleteXinTemplateTypeByIds(ids);
    }

    /**
     * 删除模板类型信息
     * 
     * @param id 模板类型主键
     * @return 结果
     */
    @Override
    public int deleteXinTemplateTypeById(Long id)
    {
        return xinTemplateTypeMapper.deleteXinTemplateTypeById(id);
    }
}
