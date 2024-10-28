package org.jeecg.modules.demo.test2.service;

import org.jeecg.modules.demo.test2.entity.WhEmp;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: wh员工
 * @Author: jeecg-boot
 * @Date:   2024-10-24
 * @Version: V1.0
 */
public interface IWhEmpService extends IService<WhEmp> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<WhEmp>
	 */
	public List<WhEmp> selectByMainId(String mainId);
}
