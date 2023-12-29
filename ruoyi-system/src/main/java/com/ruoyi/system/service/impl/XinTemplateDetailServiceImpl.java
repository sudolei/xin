package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XinTemplateDetailMapper;
import com.ruoyi.system.domain.XinTemplateDetail;
import com.ruoyi.system.service.IXinTemplateDetailService;

/**
 * 模板详细信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Service
public class XinTemplateDetailServiceImpl implements IXinTemplateDetailService 
{
    @Autowired
    private XinTemplateDetailMapper xinTemplateDetailMapper;

    /**
     * 查询模板详细信息
     * 
     * @param id 模板详细信息主键
     * @return 模板详细信息
     */
    @Override
    public XinTemplateDetail selectXinTemplateDetailById(Long id)
    {
        return xinTemplateDetailMapper.selectXinTemplateDetailById(id);
    }

    /**
     * 查询模板详细信息列表
     * 
     * @param xinTemplateDetail 模板详细信息
     * @return 模板详细信息
     */
    @Override
    public List<XinTemplateDetail> selectXinTemplateDetailList(XinTemplateDetail xinTemplateDetail)
    {
        return xinTemplateDetailMapper.selectXinTemplateDetailList(xinTemplateDetail);
    }

    /**
     * 新增模板详细信息
     * 
     * @param xinTemplateDetail 模板详细信息
     * @return 结果
     */
    @Override
    public int insertXinTemplateDetail(XinTemplateDetail xinTemplateDetail)
    {
        xinTemplateDetail.setCreateTime(DateUtils.getNowDate());
        return xinTemplateDetailMapper.insertXinTemplateDetail(xinTemplateDetail);
    }

    /**
     * 修改模板详细信息
     * 
     * @param xinTemplateDetail 模板详细信息
     * @return 结果
     */
    @Override
    public int updateXinTemplateDetail(XinTemplateDetail xinTemplateDetail)
    {
        xinTemplateDetail.setUpdateTime(DateUtils.getNowDate());
        return xinTemplateDetailMapper.updateXinTemplateDetail(xinTemplateDetail);
    }

    /**
     * 批量删除模板详细信息
     * 
     * @param ids 需要删除的模板详细信息主键
     * @return 结果
     */
    @Override
    public int deleteXinTemplateDetailByIds(Long[] ids)
    {
        return xinTemplateDetailMapper.deleteXinTemplateDetailByIds(ids);
    }

    /**
     * 删除模板详细信息信息
     * 
     * @param id 模板详细信息主键
     * @return 结果
     */
    @Override
    public int deleteXinTemplateDetailById(Long id)
    {
        return xinTemplateDetailMapper.deleteXinTemplateDetailById(id);
    }
}
