<template xmlns:background-color="http://www.w3.org/1999/xhtml">
    <a-row :gutter="10">
      <a-col :md="12" :sm="24">
        <a-card :bordered="false">
  
          <!-- 按钮操作区域 -->
          <a-row style="margin-left: 14px">
            <a-input placeholder="请输入角色名称" v-model="roleId" style="width: 50%;"></a-input>
            <a-button @click="queryById(roleId)" type="primary">查询部门角色</a-button>
          </a-row>
          <div style="background: #fff;padding-left:16px;height: 100%; margin-top: 5px">
            <a-col>
            <a-tabs defaultActiveKey="1">
            <a-tab-pane tab="基本信息" key="1" >
                <a-form-model ref="form">
                    <a-form-model-item >
                        角色名称: {{ roleName }}
                    </a-form-model-item>
                    <a-form-model-item>
                        角色编码: {{ columns.roleCode }}
                    </a-form-model-item>
                    <a-form-model-item>
                        创建人: {{ columns.createBy }}
                    </a-form-model-item>
                    <a-form-model-item>
                        创建时间: {{ columns.createTime }}
                    </a-form-model-item>
                </a-form-model>

            </a-tab-pane>
            </a-tabs>
  
        </a-col>
            
          </div>
        </a-card>
  
      </a-col>
    </a-row>
  </template>
  <script>

    import {queryDepartRole} from '@/api/api'
    // 表头
    // const columns = [
    //   {
    //     title: '角色名称',
    //     dataIndex: 'roleName'
    //   },
    //   {
    //     title: '角色编码',
    //     dataIndex: 'roleCode',
    //   },
    //   {
    //     title: '创建人',
    //     dataIndex: 'createBy'
    //   },
    //   {
    //     title: '创建时间',
    //     dataIndex: 'createTime'
    //   }
    // ]
    export default {
      name: 'DapartRoleList',

      components: {

      },
      data() {
        return {
          roleId:"1260925293226479618",
          loading: false,
          visible: false,
          hiding: true,
          roleName:"",
          columns: [
                {
                    rolename:""
                },
                {
                    roleCode:""
                },
                {
                    createBy:""
                },
                {
                    createTime:""
                }
                ],
          url: {
            query: '/sys/sysDepartRole/queryById',
          },
        }
      },
      methods: {
        queryById(roleId){
            queryDepartRole({id:roleId}).then((res) => {
                console.log(res)

              if (res.success) {
                this.$message.success('查询成功!')
                console.log(res.result.roleName)
                this.roleName = res.result.roleName
                console.log(this.columns.roleName)
                this.columns.roleCode = res.result.roleCode
                this.columns.createBy = res.result.createBy
                console.log(this.columns.createBy)
                this.columns.createTime = res.result.createTime
              } else {
                this.$message.error(res.message)
              }
            })
        }
        
      },

    }
  </script>
  <style scoped>
    .ant-card-body .table-operator {
      margin: 15px;
    }
  
    .anty-form-btn {
      width: 100%;
      text-align: center;
    }

  
    #app .desktop {
      height: auto !important;
    }
  
    /** Button按钮间距 */
    .ant-btn {
      margin-left: 3px
    }
  
    .drawer-bootom-button {
      /*position: absolute;*/
      bottom: 0;
      width: 100%;
      border-top: 1px solid #e8e8e8;
      padding: 10px 16px;
      text-align: left;
      left: 0;
      background: #fff;
      border-radius: 0 0 2px 2px;
    }
  </style>