package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.po.PdfInfo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.PDFUtils;
import com.ruoyi.system.domain.XinTemplateDetail;
import com.ruoyi.system.mapper.XinTemplateDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XinPdfTemplateMapper;
import com.ruoyi.system.domain.XinPdfTemplate;
import com.ruoyi.system.service.IXinPdfTemplateService;

/**
 * 模板文件Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-25
 */
@Service
public class XinPdfTemplateServiceImpl implements IXinPdfTemplateService {
    @Autowired
    private XinPdfTemplateMapper xinPdfTemplateMapper;

    @Autowired
    private XinTemplateDetailMapper xinTemplateDetailMapper;

    /**
     * 查询模板文件
     *
     * @param id 模板文件主键
     * @return 模板文件
     */
    @Override
    public XinPdfTemplate selectXinPdfTemplateById(Long id) {
        return xinPdfTemplateMapper.selectXinPdfTemplateById(id);
    }

    /**
     * 查询模板文件列表
     *
     * @param xinPdfTemplate 模板文件
     * @return 模板文件
     */
    @Override
    public List<XinPdfTemplate> selectXinPdfTemplateList(XinPdfTemplate xinPdfTemplate) {
        return xinPdfTemplateMapper.selectXinPdfTemplateList(xinPdfTemplate);
    }

    /**
     * 新增模板文件
     *
     * @param xinPdfTemplate 模板文件
     * @return 结果
     */
    @Override
    public int insertXinPdfTemplate(XinPdfTemplate xinPdfTemplate) {
        xinPdfTemplate.setCreateTime(DateUtils.getNowDate());
        return xinPdfTemplateMapper.insertXinPdfTemplate(xinPdfTemplate);
    }

    /**
     * 修改模板文件
     *
     * @param xinPdfTemplate 模板文件
     * @return 结果
     */
    @Override
    public int updateXinPdfTemplate(XinPdfTemplate xinPdfTemplate) {
        xinPdfTemplate.setUpdateTime(DateUtils.getNowDate());
        return xinPdfTemplateMapper.updateXinPdfTemplate(xinPdfTemplate);
    }

    /**
     * 批量删除模板文件
     *
     * @param ids 需要删除的模板文件主键
     * @return 结果
     */
    @Override
    public int deleteXinPdfTemplateByIds(Long[] ids) {
        return xinPdfTemplateMapper.deleteXinPdfTemplateByIds(ids);
    }

    /**
     * 删除模板文件信息
     *
     * @param id 模板文件主键
     * @return 结果
     */
    @Override
    public int deleteXinPdfTemplateById(Long id) {
        return xinPdfTemplateMapper.deleteXinPdfTemplateById(id);
    }

    @Override
    public int uploadInsertTemplate(String fileName, String newFileName) {
        List<PdfInfo> l = PDFUtils.readPdf(fileName);
        XinPdfTemplate xinPdfTemplate = new XinPdfTemplate();
        xinPdfTemplate.setTemplateName(newFileName);
        xinPdfTemplate.setPdfTemplatePath(fileName);
        xinPdfTemplate.setPdfTemplateCoverPath(fileName);
        xinPdfTemplate.setTemplateType(1l);
        xinPdfTemplate.setPicNum((long) l.size());
        int result = xinPdfTemplateMapper.insertXinPdfTemplate(xinPdfTemplate);
        for (PdfInfo info : l) {
            XinTemplateDetail detail = new XinTemplateDetail();
            detail.setTemplateId(xinPdfTemplate.getId());
            detail.setPgeNum((long) info.getPage());
            detail.setWidth(String.valueOf(info.getWidth()));
            detail.setHeight(String.valueOf(info.getHeight()));
            detail.setxCenterCoord(String.valueOf(info.getXcenter()));
            detail.setyCenterCoord(String.valueOf(info.getYcenter()));
            xinTemplateDetailMapper.insertXinTemplateDetail(detail);
        }
        return result;
    }
}
