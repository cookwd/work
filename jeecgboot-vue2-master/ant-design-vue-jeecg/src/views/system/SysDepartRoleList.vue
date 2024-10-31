<template xmlns:background-color="http://www.w3.org/1999/xhtml">
    <a-row :gutter="10">
      <a-col :md="12" :sm="24">
        <a-card :bordered="false">
  
          <div class="table-page-search-wrapper">
            <!-- 搜索区域 -->
            <a-form layout="inline" @keyup.enter.native="searchQuery">
              <a-row :gutter="24">
                <a-col :md="12" :sm="8">
                  <a-form-item label="部门角色名称" :labelCol="{span: 5}" :wrapperCol="{span: 18, offset: 1}">
                    <a-input placeholder="" v-model="queryParam.departRoleName"></a-input>
                  </a-form-item>
                </a-col>
                <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
              <a-col :md="12" :sm="24">
                <a-button type="primary" @click="searchQuery" icon="search" style="margin-left: 21px">查询</a-button>
                <a-button type="primary" @click="searchReset" icon="reload" style="margin-left: 8px">重置</a-button>
              </a-col>
            </span>
              </a-row>
            </a-form>
            <!-- table区域-begin -->
            <div>
              <div class="ant-alert ant-alert-info" style="margin-bottom: 16px;">
                <i class="anticon anticon-info-circle ant-alert-icon"></i> 已选择 <a style="font-weight: 600">{{
                selectedRowKeys2.length }}</a>项
                <a style="margin-left: 24px" @click="onClearSelected">清空</a>
              </div>
              <a-table
                style="height:500px"
                ref="table2"
                bordered
                size="middle"
                rowKey="id"
                :columns="columns"
                :dataSource="dataSource"
                :pagination="ipagination"
                :loading="loading2"
                :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
                @change="handleTableChange2">
                <span slot="action" slot-scope="text, record">
                  <a @click="handleEdit2(record)">编辑</a>
                  <a-divider type="vertical"/>
                  <a-dropdown>
                    <a class="ant-dropdown-link">
                      更多 <a-icon type="down"/>
                    </a>
                    <a-menu slot="overlay">
                      <a-menu-item>
                        <a-popconfirm title="确定取消关联吗?" @confirm="() => handleDelete2(record.id)">
                          <a>取消关联</a>
                        </a-popconfirm>
                      </a-menu-item>
                    </a-menu>
                  </a-dropdown>
                </span>
              </a-table>
            </div>
          </div>
        </a-card>
  
      </a-col>
    </a-row>
  </template>
  <script>

    import {queryDepartRole} from '@/api/api'

    
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