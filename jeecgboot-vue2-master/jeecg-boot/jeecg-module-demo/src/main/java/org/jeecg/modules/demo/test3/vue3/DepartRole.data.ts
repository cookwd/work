import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';

export const columns: BasicColumn[] = [
    {
    title: '部门id',
    dataIndex: 'departId'
   },
   {
    title: '部门角色名称',
    dataIndex: 'roleName'
   },
   {
    title: '部门角色编码',
    dataIndex: 'roleCode'
   },
   {
    title: '描述',
    dataIndex: 'description'
   },
];

export const searchFormSchema: FormSchema[] = [
 {
    label: '部门id',
    field: 'departId',
    component: 'Input'
  },
 {
    label: '部门角色名称',
    field: 'roleName',
    component: 'Input'
  },
];

export const formSchema: FormSchema[] = [
  // TODO 主键隐藏字段，目前写死为ID
  {label: '', field: 'id', component: 'Input', show: false},
  {
    label: '部门id',
    field: 'departId',
    component: 'Input',
  },
  {
    label: '部门角色名称',
    field: 'roleName',
    component: 'Input',
  },
  {
    label: '部门角色编码',
    field: 'roleCode',
    component: 'Input',
  },
  {
    label: '描述',
    field: 'description',
    component: 'Input',
  },
];
