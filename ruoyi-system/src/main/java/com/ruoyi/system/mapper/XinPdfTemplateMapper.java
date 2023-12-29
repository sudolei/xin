package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XinPdfTemplate;

/**
 * 模板文件Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public interface XinPdfTemplateMapper 
{
    /**
     * 查询模板文件
     * 
     * @param id 模板文件主键
     * @return 模板文件
     */
    public XinPdfTemplate selectXinPdfTemplateById(Long id);

    /**
     * 查询模板文件列表
     * 
     * @param xinPdfTemplate 模板文件
     * @return 模板文件集合
     */
    public List<XinPdfTemplate> selectXinPdfTemplateList(XinPdfTemplate xinPdfTemplate);

    /**
     * 新增模板文件
     * 
     * @param xinPdfTemplate 模板文件
     * @return 结果
     */
    public int insertXinPdfTemplate(XinPdfTemplate xinPdfTemplate);

    /**
     * 修改模板文件
     * 
     * @param xinPdfTemplate 模板文件
     * @return 结果
     */
    public int updateXinPdfTemplate(XinPdfTemplate xinPdfTemplate);

    /**
     * 删除模板文件
     * 
     * @param id 模板文件主键
     * @return 结果
     */
    public int deleteXinPdfTemplateById(Long id);

    /**
     * 批量删除模板文件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXinPdfTemplateByIds(Long[] ids);
}
