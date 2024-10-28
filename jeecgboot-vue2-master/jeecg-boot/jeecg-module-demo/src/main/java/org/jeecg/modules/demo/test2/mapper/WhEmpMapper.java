package org.jeecg.modules.demo.test2.mapper;

import java.util.List;
import org.jeecg.modules.demo.test2.entity.WhEmp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: wh员工
 * @Author: jeecg-boot
 * @Date:   2024-10-24
 * @Version: V1.0
 */
public interface WhEmpMapper extends BaseMapper<WhEmp> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<WhEmp>
   */
	public List<WhEmp> selectByMainId(@Param("mainId") String mainId);
}
