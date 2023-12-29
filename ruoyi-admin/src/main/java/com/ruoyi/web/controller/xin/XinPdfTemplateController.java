package com.ruoyi.web.controller.xin;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.XinPdfTemplate;
import com.ruoyi.system.service.IXinPdfTemplateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模板文件Controller
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@RestController
@RequestMapping("/xin/template")
public class XinPdfTemplateController extends BaseController
{
    @Autowired
    private IXinPdfTemplateService xinPdfTemplateService;

    /**
     * 查询模板文件列表
     */
    @PreAuthorize("@ss.hasPermi('xin:template:list')")
    @GetMapping("/list")
    public TableDataInfo list(XinPdfTemplate xinPdfTemplate)
    {
        startPage();
        List<XinPdfTemplate> list = xinPdfTemplateService.selectXinPdfTemplateList(xinPdfTemplate);
        return getDataTable(list);
    }

    /**
     * 导出模板文件列表
     */
    @PreAuthorize("@ss.hasPermi('xin:template:export')")
    @Log(title = "模板文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XinPdfTemplate xinPdfTemplate)
    {
        List<XinPdfTemplate> list = xinPdfTemplateService.selectXinPdfTemplateList(xinPdfTemplate);
        ExcelUtil<XinPdfTemplate> util = new ExcelUtil<XinPdfTemplate>(XinPdfTemplate.class);
        util.exportExcel(response, list, "模板文件数据");
    }

    /**
     * 获取模板文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('xin:template:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xinPdfTemplateService.selectXinPdfTemplateById(id));
    }

    /**
     * 新增模板文件
     */
    @PreAuthorize("@ss.hasPermi('xin:template:add')")
    @Log(title = "模板文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XinPdfTemplate xinPdfTemplate)
    {
        return toAjax(xinPdfTemplateService.insertXinPdfTemplate(xinPdfTemplate));
    }

    /**
     * 修改模板文件
     */
    @PreAuthorize("@ss.hasPermi('xin:template:edit')")
    @Log(title = "模板文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XinPdfTemplate xinPdfTemplate)
    {
        return toAjax(xinPdfTemplateService.updateXinPdfTemplate(xinPdfTemplate));
    }

    /**
     * 删除模板文件
     */
    @PreAuthorize("@ss.hasPermi('xin:template:remove')")
    @Log(title = "模板文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xinPdfTemplateService.deleteXinPdfTemplateByIds(ids));
    }
}
