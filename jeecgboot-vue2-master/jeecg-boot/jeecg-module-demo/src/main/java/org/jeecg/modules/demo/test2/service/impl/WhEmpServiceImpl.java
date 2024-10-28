package org.jeecg.modules.demo.test2.service.impl;

import org.jeecg.modules.demo.test2.entity.WhEmp;
import org.jeecg.modules.demo.test2.mapper.WhEmpMapper;
import org.jeecg.modules.demo.test2.service.IWhEmpService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: wh员工
 * @Author: jeecg-boot
 * @Date:   2024-10-24
 * @Version: V1.0
 */
@Service
public class WhEmpServiceImpl extends ServiceImpl<WhEmpMapper, WhEmp> implements IWhEmpService {
	
	@Autowired
	private WhEmpMapper whEmpMapper;
	
	@Override
	public List<WhEmp> selectByMainId(String mainId) {
		return whEmpMapper.selectByMainId(mainId);
	}
}
