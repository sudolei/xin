package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XinTemplateDetail;

/**
 * 模板详细信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public interface XinTemplateDetailMapper 
{
    /**
     * 查询模板详细信息
     * 
     * @param id 模板详细信息主键
     * @return 模板详细信息
     */
    public XinTemplateDetail selectXinTemplateDetailById(Long id);

    /**
     * 查询模板详细信息列表
     * 
     * @param xinTemplateDetail 模板详细信息
     * @return 模板详细信息集合
     */
    public List<XinTemplateDetail> selectXinTemplateDetailList(XinTemplateDetail xinTemplateDetail);

    /**
     * 新增模板详细信息
     * 
     * @param xinTemplateDetail 模板详细信息
     * @return 结果
     */
    public int insertXinTemplateDetail(XinTemplateDetail xinTemplateDetail);

    /**
     * 修改模板详细信息
     * 
     * @param xinTemplateDetail 模板详细信息
     * @return 结果
     */
    public int updateXinTemplateDetail(XinTemplateDetail xinTemplateDetail);

    /**
     * 删除模板详细信息
     * 
     * @param id 模板详细信息主键
     * @return 结果
     */
    public int deleteXinTemplateDetailById(Long id);

    /**
     * 批量删除模板详细信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXinTemplateDetailByIds(Long[] ids);
}
