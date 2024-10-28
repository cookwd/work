-- 注意：该页面对应的前台目录为views/test1文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2024102310149600390', NULL, '网禾用户', '/test1/whUserList', 'test1/WhUserList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 1, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2024-10-23 10:14:39', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102310149600391', '2024102310149600390', '添加网禾用户', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_user:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-23 10:14:39', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102310149600392', '2024102310149600390', '编辑网禾用户', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_user:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-23 10:14:39', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102310149600393', '2024102310149600390', '删除网禾用户', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_user:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-23 10:14:39', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102310149600394', '2024102310149600390', '批量删除网禾用户', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_user:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-23 10:14:39', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102310149600395', '2024102310149600390', '导出excel_网禾用户', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_user:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-23 10:14:39', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2024102310149600396', '2024102310149600390', '导入excel_网禾用户', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.demo:wh_user:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-10-23 10:14:39', NULL, NULL, 0, 0, '1', 0);