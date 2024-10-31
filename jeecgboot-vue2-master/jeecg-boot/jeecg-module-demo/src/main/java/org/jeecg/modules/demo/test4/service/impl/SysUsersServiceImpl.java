package org.jeecg.modules.demo.test4.service.impl;

import org.jeecg.modules.demo.test4.entity.SysUsers;
import org.jeecg.modules.demo.test4.mapper.SysUsersMapper;
import org.jeecg.modules.demo.test4.service.ISysUsersService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: sys_user
 * @Author: jeecg-boot
 * @Date:   2024-10-31
 * @Version: V1.0
 */
@Service
public class SysUsersServiceImpl extends ServiceImpl<SysUsersMapper, SysUsers> implements ISysUsersService {
	
	@Autowired
	private SysUsersMapper sysUsersMapper;
	
	@Override
	public List<SysUsers> selectByMainId(String mainId) {
		return sysUsersMapper.selectByMainId(mainId);
	}
}
