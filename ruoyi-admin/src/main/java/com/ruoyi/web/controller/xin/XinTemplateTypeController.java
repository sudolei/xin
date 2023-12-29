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
import com.ruoyi.system.domain.XinTemplateType;
import com.ruoyi.system.service.IXinTemplateTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模板类型Controller
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@RestController
@RequestMapping("/xin/type")
public class XinTemplateTypeController extends BaseController
{
    @Autowired
    private IXinTemplateTypeService xinTemplateTypeService;

    /**
     * 查询模板类型列表
     */
    @PreAuthorize("@ss.hasPermi('xin:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(XinTemplateType xinTemplateType)
    {
        startPage();
        List<XinTemplateType> list = xinTemplateTypeService.selectXinTemplateTypeList(xinTemplateType);
        return getDataTable(list);
    }

    /**
     * 导出模板类型列表
     */
    @PreAuthorize("@ss.hasPermi('xin:type:export')")
    @Log(title = "模板类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XinTemplateType xinTemplateType)
    {
        List<XinTemplateType> list = xinTemplateTypeService.selectXinTemplateTypeList(xinTemplateType);
        ExcelUtil<XinTemplateType> util = new ExcelUtil<XinTemplateType>(XinTemplateType.class);
        util.exportExcel(response, list, "模板类型数据");
    }

    /**
     * 获取模板类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('xin:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xinTemplateTypeService.selectXinTemplateTypeById(id));
    }

    /**
     * 新增模板类型
     */
    @PreAuthorize("@ss.hasPermi('xin:type:add')")
    @Log(title = "模板类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XinTemplateType xinTemplateType)
    {
        return toAjax(xinTemplateTypeService.insertXinTemplateType(xinTemplateType));
    }

    /**
     * 修改模板类型
     */
    @PreAuthorize("@ss.hasPermi('xin:type:edit')")
    @Log(title = "模板类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XinTemplateType xinTemplateType)
    {
        return toAjax(xinTemplateTypeService.updateXinTemplateType(xinTemplateType));
    }

    /**
     * 删除模板类型
     */
    @PreAuthorize("@ss.hasPermi('xin:type:remove')")
    @Log(title = "模板类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xinTemplateTypeService.deleteXinTemplateTypeByIds(ids));
    }
}
