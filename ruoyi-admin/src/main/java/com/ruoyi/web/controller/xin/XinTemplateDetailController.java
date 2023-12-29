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
import com.ruoyi.system.domain.XinTemplateDetail;
import com.ruoyi.system.service.IXinTemplateDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 模板详细信息Controller
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@RestController
@RequestMapping("/xin/detail")
public class XinTemplateDetailController extends BaseController
{
    @Autowired
    private IXinTemplateDetailService xinTemplateDetailService;

    /**
     * 查询模板详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('xin:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(XinTemplateDetail xinTemplateDetail)
    {
        startPage();
        List<XinTemplateDetail> list = xinTemplateDetailService.selectXinTemplateDetailList(xinTemplateDetail);
        return getDataTable(list);
    }

    /**
     * 导出模板详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('xin:detail:export')")
    @Log(title = "模板详细信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XinTemplateDetail xinTemplateDetail)
    {
        List<XinTemplateDetail> list = xinTemplateDetailService.selectXinTemplateDetailList(xinTemplateDetail);
        ExcelUtil<XinTemplateDetail> util = new ExcelUtil<XinTemplateDetail>(XinTemplateDetail.class);
        util.exportExcel(response, list, "模板详细信息数据");
    }

    /**
     * 获取模板详细信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('xin:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xinTemplateDetailService.selectXinTemplateDetailById(id));
    }

    /**
     * 新增模板详细信息
     */
    @PreAuthorize("@ss.hasPermi('xin:detail:add')")
    @Log(title = "模板详细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XinTemplateDetail xinTemplateDetail)
    {
        return toAjax(xinTemplateDetailService.insertXinTemplateDetail(xinTemplateDetail));
    }

    /**
     * 修改模板详细信息
     */
    @PreAuthorize("@ss.hasPermi('xin:detail:edit')")
    @Log(title = "模板详细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XinTemplateDetail xinTemplateDetail)
    {
        return toAjax(xinTemplateDetailService.updateXinTemplateDetail(xinTemplateDetail));
    }

    /**
     * 删除模板详细信息
     */
    @PreAuthorize("@ss.hasPermi('xin:detail:remove')")
    @Log(title = "模板详细信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xinTemplateDetailService.deleteXinTemplateDetailByIds(ids));
    }
}
