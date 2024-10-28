package org.jeecg.modules.demo.test2.service.impl;

import org.jeecg.modules.demo.test2.entity.WhDepartment;
import org.jeecg.modules.demo.test2.entity.WhEmp;
import org.jeecg.modules.demo.test2.mapper.WhEmpMapper;
import org.jeecg.modules.demo.test2.mapper.WhDepartmentMapper;
import org.jeecg.modules.demo.test2.service.IWhDepartmentService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: wh部门
 * @Author: jeecg-boot
 * @Date:   2024-10-24
 * @Version: V1.0
 */
@Service
public class WhDepartmentServiceImpl extends ServiceImpl<WhDepartmentMapper, WhDepartment> implements IWhDepartmentService {

	@Autowired
	private WhDepartmentMapper whDepartmentMapper;
	@Autowired
	private WhEmpMapper whEmpMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(WhDepartment whDepartment, List<WhEmp> whEmpList) {
		whDepartmentMapper.insert(whDepartment);
		if(whEmpList!=null && whEmpList.size()>0) {
			for(WhEmp entity:whEmpList) {
				//外键设置
				entity.setDepartId(whDepartment.getId());
				whEmpMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(WhDepartment whDepartment,List<WhEmp> whEmpList) {
		whDepartmentMapper.updateById(whDepartment);
		
		//1.先删除子表数据
		whEmpMapper.deleteByMainId(whDepartment.getId());
		
		//2.子表数据重新插入
		if(whEmpList!=null && whEmpList.size()>0) {
			for(WhEmp entity:whEmpList) {
				//外键设置
				entity.setDepartId(whDepartment.getId());
				whEmpMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		whEmpMapper.deleteByMainId(id);
		whDepartmentMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			whEmpMapper.deleteByMainId(id.toString());
			whDepartmentMapper.deleteById(id);
		}
	}
	
}
