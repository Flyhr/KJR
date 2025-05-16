<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="电话号码" prop="phoneNumber">
        <el-input
          v-model="queryParams.phoneNumber"
          placeholder="请输入电话号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属角色" prop="roleId">
        <el-input
          v-model="queryParams.roleId"
          placeholder="请输入所属角色"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最近一次登录时间" prop="loginDate">
        <el-date-picker clearable
          v-model="queryParams.loginDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最近一次登录时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="账号状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择账号状态" clearable>
          <el-option
            v-for="dict in dict.type.sys_job_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
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
          v-hasPermi="['DocSys:Doc:add']"
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
          v-hasPermi="['DocSys:Doc:edit']"
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
          v-hasPermi="['DocSys:Doc:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['DocSys:Doc:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="DocList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="医生ID" align="center" prop="userId" />
      <el-table-column label="姓名" align="center" prop="userName" />
      <el-table-column label="电话号码" align="center" prop="phoneNumber" />
      <el-table-column label="所属角色" align="center" prop="roleId" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="最近一次登录时间" align="center" prop="loginDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.loginDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="账号状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_job_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['DocSys:Doc:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['DocSys:Doc:remove']"
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

    <!-- 添加或修改医生信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="昵称" prop="nickName">
          <el-input v-model="form.nickName" placeholder="请输入昵称" />
        </el-form-item>
        <el-form-item label="电话号码" prop="phoneNumber">
          <el-input v-model="form.phoneNumber" placeholder="请输入电话号码" />
        </el-form-item>
        <el-form-item label="登录密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入登录密码" />
        </el-form-item>
        <el-form-item label="所属角色" prop="roleId">
          <el-input v-model="form.roleId" placeholder="请输入所属角色" />
        </el-form-item>
        <el-form-item label="所属部门" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入所属部门" />
        </el-form-item>
        <el-form-item label="数据权限" prop="dataScope">
          <el-input v-model="form.dataScope" placeholder="请输入数据权限" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="擅长领域" prop="speciality">
          <el-input v-model="form.speciality" placeholder="请输入擅长领域" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-radio-group v-model="form.delFlag">
            <el-radio
              v-for="dict in dict.type.sys_job_status"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="用户头像地址" prop="avatar">
          <el-input v-model="form.avatar" placeholder="请输入用户头像地址" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="最近一次登录时间" prop="loginDate">
          <el-date-picker clearable
            v-model="form.loginDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最近一次登录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="账号状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_job_status"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-divider content-position="center">医生患者关系信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddDoctorPatientRelation">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteDoctorPatientRelation">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="doctorPatientRelationList" :row-class-name="rowDoctorPatientRelationIndex" @selection-change="handleDoctorPatientRelationSelectionChange" ref="doctorPatientRelation">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="医生ID" prop="docId" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.docId" placeholder="请输入医生ID" />
            </template>
          </el-table-column>
          <el-table-column label="患者ID" prop="patId" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.patId" placeholder="请输入患者ID" />
            </template>
          </el-table-column>
          <el-table-column label="关系建立时间" prop="createTime" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.createTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择关系建立时间" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDoc, getDoc, delDoc, addDoc, updateDoc } from "@/api/DocSys/Doc";

export default {
  name: "Doc",
  dicts: ['sys_job_status', 'sys_user_sex'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedDoctorPatientRelation: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 医生信息表格数据
      DocList: [],
      // 医生患者关系表格数据
      doctorPatientRelationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userName: null,
        phoneNumber: null,
        roleId: null,
        email: null,
        loginDate: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        nickName: [
          { required: true, message: "昵称不能为空", trigger: "blur" }
        ],
        phoneNumber: [
          { required: true, message: "电话号码不能为空", trigger: "blur" }
        ],
        password: [
          { required: true, message: "登录密码不能为空", trigger: "blur" }
        ],
        roleId: [
          { required: true, message: "所属角色不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        delFlag: [
          { required: true, message: "删除标志不能为空", trigger: "change" }
        ],
        status: [
          { required: true, message: "账号状态不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询医生信息列表 */
    getList() {
      this.loading = true;
      listDoc(this.queryParams).then(response => {
        this.DocList = response.rows;
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
        userId: null,
        userName: null,
        nickName: null,
        phoneNumber: null,
        password: null,
        roleId: null,
        deptId: null,
        dataScope: null,
        sex: null,
        email: null,
        speciality: null,
        updateTime: null,
        createTime: null,
        delFlag: null,
        avatar: null,
        remark: null,
        loginDate: null,
        status: null
      };
      this.doctorPatientRelationList = [];
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
      this.ids = selection.map(item => item.userId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加医生信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const userId = row.userId || this.ids
      getDoc(userId).then(response => {
        this.form = response.data;
        this.doctorPatientRelationList = response.data.doctorPatientRelationList;
        this.open = true;
        this.title = "修改医生信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.doctorPatientRelationList = this.doctorPatientRelationList;
          if (this.form.userId != null) {
            updateDoc(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDoc(this.form).then(response => {
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
      const userIds = row.userId || this.ids;
      this.$modal.confirm('是否确认删除医生信息编号为"' + userIds + '"的数据项？').then(function() {
        return delDoc(userIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 医生患者关系序号 */
    rowDoctorPatientRelationIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 医生患者关系添加按钮操作 */
    handleAddDoctorPatientRelation() {
      let obj = {};
      obj.docId = "";
      obj.patId = "";
      obj.createTime = "";
      this.doctorPatientRelationList.push(obj);
    },
    /** 医生患者关系删除按钮操作 */
    handleDeleteDoctorPatientRelation() {
      if (this.checkedDoctorPatientRelation.length == 0) {
        this.$modal.msgError("请先选择要删除的医生患者关系数据");
      } else {
        const doctorPatientRelationList = this.doctorPatientRelationList;
        const checkedDoctorPatientRelation = this.checkedDoctorPatientRelation;
        this.doctorPatientRelationList = doctorPatientRelationList.filter(function(item) {
          return checkedDoctorPatientRelation.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleDoctorPatientRelationSelectionChange(selection) {
      this.checkedDoctorPatientRelation = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('DocSys/Doc/export', {
        ...this.queryParams
      }, `Doc_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
