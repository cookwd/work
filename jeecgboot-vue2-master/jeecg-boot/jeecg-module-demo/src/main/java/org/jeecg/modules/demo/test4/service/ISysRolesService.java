package org.jeecg.modules.demo.test4.service;

import org.jeecg.modules.demo.test4.entity.SysUsers;
import org.jeecg.modules.demo.test4.entity.SysRoles;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: sys_role
 * @Author: jeecg-boot
 * @Date:   2024-10-31
 * @Version: V1.0
 */
public interface ISysRolesService extends IService<SysRoles> {

	/**
	 * 添加一对多
	 *
	 * @param sysRoles
	 * @param sysUsersList
	 */
	public void saveMain(SysRoles sysRoles,List<SysUsers> sysUsersList) ;
	
	/**
	 * 修改一对多
	 *
   * @param sysRoles
   * @param sysUsersList
	 */
	public void updateMain(SysRoles sysRoles,List<SysUsers> sysUsersList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
