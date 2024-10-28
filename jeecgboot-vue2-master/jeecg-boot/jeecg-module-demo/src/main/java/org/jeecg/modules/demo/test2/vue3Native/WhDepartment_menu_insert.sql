-- 注意：该页面对应的前台目录为views/test2文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024102411266290560', NULL, 'wh部门', '/test2/whDepartmentList', 'test2/WhDepartmentList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 1, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-10-24 11:26:56', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102411266300561', '2024102411266290560', '添加wh部门', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_department:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-24 11:26:56', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102411266300562', '2024102411266290560', '编辑wh部门', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_department:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-24 11:26:56', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102411266300563', '2024102411266290560', '删除wh部门', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_department:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-24 11:26:56', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102411266300564', '2024102411266290560', '批量删除wh部门', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_department:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-24 11:26:56', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102411266300565', '2024102411266290560', '导出excel_wh部门', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_department:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-24 11:26:56', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102411266300566', '2024102411266290560', '导入excel_wh部门', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_department:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-24 11:26:56', NULL, NULL, 0, 0, '1', 0);