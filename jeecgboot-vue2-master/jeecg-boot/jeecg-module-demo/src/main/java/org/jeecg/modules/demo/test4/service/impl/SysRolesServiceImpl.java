package org.jeecg.modules.demo.test4.service.impl;

import org.jeecg.modules.demo.test4.entity.SysRoles;
import org.jeecg.modules.demo.test4.entity.SysUsers;
import org.jeecg.modules.demo.test4.mapper.SysUsersMapper;
import org.jeecg.modules.demo.test4.mapper.SysRolesMapper;
import org.jeecg.modules.demo.test4.service.ISysRolesService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: sys_role
 * @Author: jeecg-boot
 * @Date:   2024-10-31
 * @Version: V1.0
 */
@Service
public class SysRolesServiceImpl extends ServiceImpl<SysRolesMapper, SysRoles> implements ISysRolesService {

	@Autowired
	private SysRolesMapper sysRolesMapper;
	@Autowired
	private SysUsersMapper sysUsersMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(SysRoles sysRoles, List<SysUsers> sysUsersList) {
		sysRolesMapper.insert(sysRoles);
		if(sysUsersList!=null && sysUsersList.size()>0) {
			for(SysUsers entity:sysUsersList) {
				//外键设置
				entity.setRoleId(sysRoles.getId());
				sysUsersMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(SysRoles sysRoles,List<SysUsers> sysUsersList) {
		sysRolesMapper.updateById(sysRoles);
		
		//1.先删除子表数据
		sysUsersMapper.deleteByMainId(sysRoles.getId());
		
		//2.子表数据重新插入
		if(sysUsersList!=null && sysUsersList.size()>0) {
			for(SysUsers entity:sysUsersList) {
				//外键设置
				entity.setRoleId(sysRoles.getId());
				sysUsersMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		sysUsersMapper.deleteByMainId(id);
		sysRolesMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			sysUsersMapper.deleteByMainId(id.toString());
			sysRolesMapper.deleteById(id);
		}
	}
	
}
