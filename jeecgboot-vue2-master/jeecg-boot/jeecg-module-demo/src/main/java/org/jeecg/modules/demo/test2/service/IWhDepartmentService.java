package org.jeecg.modules.demo.test2.service;

import org.jeecg.modules.demo.test2.entity.WhEmp;
import org.jeecg.modules.demo.test2.entity.WhDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: wh部门
 * @Author: jeecg-boot
 * @Date:   2024-10-24
 * @Version: V1.0
 */
public interface IWhDepartmentService extends IService<WhDepartment> {

	/**
	 * 添加一对多
	 *
	 * @param whDepartment
	 * @param whEmpList
	 */
	public void saveMain(WhDepartment whDepartment,List<WhEmp> whEmpList) ;
	
	/**
	 * 修改一对多
	 *
   * @param whDepartment
   * @param whEmpList
	 */
	public void updateMain(WhDepartment whDepartment,List<WhEmp> whEmpList);
	
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
