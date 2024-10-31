package org.jeecg.modules.demo.test4.service;

import org.jeecg.modules.demo.test4.entity.SysUsers;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: sys_user
 * @Author: jeecg-boot
 * @Date:   2024-10-31
 * @Version: V1.0
 */
public interface ISysUsersService extends IService<SysUsers> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<SysUsers>
	 */
	public List<SysUsers> selectByMainId(String mainId);
}
