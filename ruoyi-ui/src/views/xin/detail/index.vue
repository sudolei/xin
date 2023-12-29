<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['xin:detail:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['xin:detail:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['xin:detail:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['xin:detail:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="detailList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="模板编号" align="center" prop="templateId" />
      <el-table-column label="页数" align="center" prop="pgeNum" />
      <el-table-column label="x中心坐标" align="center" prop="xCenterCoord" />
      <el-table-column label="y中心坐标" align="center" prop="yCenterCoord" />
      <el-table-column label="x开始坐标" align="center" prop="xStartCoord" />
      <el-table-column label="y开始坐标" align="center" prop="yStartCoord" />
      <el-table-column label="高度" align="center" prop="height" />
      <el-table-column label="宽度" align="center" prop="width" />
      <el-table-column label="${comment}" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['xin:detail:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['xin:detail:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改模板详细信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="页数" prop="pgeNum">
          <el-input v-model="form.pgeNum" placeholder="请输入页数" />
        </el-form-item>
        <el-form-item label="x中心坐标" prop="xCenterCoord">
          <el-input v-model="form.xCenterCoord" placeholder="请输入x中心坐标" />
        </el-form-item>
        <el-form-item label="y中心坐标" prop="yCenterCoord">
          <el-input v-model="form.yCenterCoord" placeholder="请输入y中心坐标" />
        </el-form-item>
        <el-form-item label="x开始坐标" prop="xStartCoord">
          <el-input v-model="form.xStartCoord" placeholder="请输入x开始坐标" />
        </el-form-item>
        <el-form-item label="y开始坐标" prop="yStartCoord">
          <el-input v-model="form.yStartCoord" placeholder="请输入y开始坐标" />
        </el-form-item>
        <el-form-item label="高度" prop="height">
          <el-input v-model="form.height" placeholder="请输入高度" />
        </el-form-item>
        <el-form-item label="宽度" prop="width">
          <el-input v-model="form.width" placeholder="请输入宽度" />
        </el-form-item>
        <el-form-item label="${comment}" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入${comment}" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDetail, getDetail, delDetail, addDetail, updateDetail } from "@/api/xin/detail";

export default {
  name: "Detail",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 模板详细信息表格数据
      detailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        templateId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询模板详细信息列表 */
    getList() {
      this.loading = true;
      listDetail(this.queryParams).then(response => {
        this.detailList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        templateId: null,
        pgeNum: null,
        xCenterCoord: null,
        yCenterCoord: null,
        xStartCoord: null,
        yStartCoord: null,
        height: null,
        width: null,
        createBy: null,
        updateBy: null,
        createTime: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加模板详细信息";
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDetail(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改模板详细信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDetail(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDetail(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除模板详细信息编号为"' + ids + '"的数据项？').then(function() {
        return delDetail(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('xin/detail/export', {
        ...this.queryParams
      }, `detail_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
