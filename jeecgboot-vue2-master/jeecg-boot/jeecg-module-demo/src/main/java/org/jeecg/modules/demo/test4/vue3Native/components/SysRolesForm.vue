<template>
  <a-spin :spinning="loading">
    <a-form v-bind="formItemLayout">
      <a-row>
        <a-col :span="24">
          <a-form-item label="角色名称" v-bind="validateInfos.roleName">
            <a-input v-model:value="formData.roleName" placeholder="请输入角色名称" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="角色编码" v-bind="validateInfos.roleCode">
            <a-input v-model:value="formData.roleCode" placeholder="请输入角色编码" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="描述" v-bind="validateInfos.description">
            <a-input v-model:value="formData.description" placeholder="请输入描述" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="userId" v-bind="validateInfos.userId">
            <a-input v-model:value="formData.userId" placeholder="请输入userId" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>

		<!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey">
      <a-tab-pane tab="sys_user" key="sysUsers" :forceRender="true">
        <j-vxe-table
          :keep-source="true"
          ref="sysUsersTableRef"
          v-if="sysUsersTable.show"
          :loading="sysUsersTable.loading"
          :columns="sysUsersTable.columns"
          :dataSource="sysUsersTable.dataSource"
          :height="340"
          :disabled="disabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"/>
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script lang="ts">
  import { defineComponent, ref, reactive, computed, toRaw, onMounted } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useValidateAntFormAndTable } from '/@/hooks/system/useJvxeMethods';
  import { querySysUsersListByMainId, queryDataById, saveOrUpdate } from '../SysRoles.api';
  import { JVxeTable } from '/@/components/jeecg/JVxeTable';
  import {sysUsersColumns} from '../SysRoles.data';
  import { Form } from 'ant-design-vue';
  const useForm = Form.useForm;

  export default defineComponent({
    name: "SysRolesForm",
    components:{
      JVxeTable,
    },
    props:{
      formDisabled:{
        type: Boolean,
        default: false
      },
      formData: { type: Object, default: ()=>{} },
      formBpm: { type: Boolean, default: true }
    },
    emits:['success'],
    setup(props, {emit}) {
      const loading = ref(false);
      const sysUsersTableRef = ref();
      const sysUsersTable = reactive<Record<string, any>>({
        loading: false,
        columns: sysUsersColumns,
        dataSource: [],
        show: false
      });
      const activeKey = ref('sysUsers');
      const formData = reactive<Record<string, any>>({
        id: '',
        roleName: '',
        roleCode: '',
        description: '',
        userId: '',
      });

      //表单验证
      const validatorRules = reactive({
        roleCode: [{ required: true, message: '请输入角色编码!'},],
      });
      const {resetFields, validate, validateInfos} = useForm(formData, validatorRules, {immediate: true});
      const dbData = {};
      const formItemLayout = {
        labelCol: {xs: {span: 24}, sm: {span: 5}},
        wrapperCol: {xs: {span: 24}, sm: {span: 16}},
      };

      // 表单禁用
      const disabled = computed(()=>{
        if(props.formBpm === true){
          if(props.formData.disabled === false){
            return false;
          }else{
            return true;
          }
        }
        return props.formDisabled;
      });

      

      function add() {
        resetFields();
        sysUsersTable.dataSource = [];
      }

      async function edit(row) {
        //主表数据
        await queryMainData(row.id);
        //子表数据
        const sysUsersDataList = await querySysUsersListByMainId(row['id']);
        sysUsersTable.dataSource = [...sysUsersDataList];
      }

      async function queryMainData(id) {
        const row = await queryDataById(id);
        Object.keys(row).map(k => {
          formData[k] = row[k];
        });
      }

      const {getSubFormAndTableData, transformData} = useValidateAntFormAndTable(activeKey, {
        'sysUsers': sysUsersTableRef,
      });

      async function getFormData() {
        await validate();
        return transformData(toRaw(formData))
      }

      async function submitForm() {
        const mainData = await getFormData();
        const subData = await getSubFormAndTableData();
        const values = Object.assign({}, dbData, mainData, subData);
        console.log('表单提交数据', values)
        const isUpdate = values.id ? true : false
        await saveOrUpdate(values, isUpdate);
        //关闭弹窗
        emit('success');
      }
      
      function setFieldsValue(values) {
        if(values){
          Object.keys(values).map(k=>{
            formData[k] = values[k];
          });
        }
      }

      /**
       * 值改变事件触发-树控件回调
       * @param key
       * @param value
       */
      function handleFormChange(key, value) {
        formData[key] = value;
      }


      return {
        sysUsersTableRef,
        sysUsersTable,
        validatorRules,
        validateInfos,
        activeKey,
        loading,
        formData,
        setFieldsValue,
        handleFormChange,
        formItemLayout,
        disabled,
        getFormData,
        submitForm,
        add,
        edit
      }
    }
  });
</script>