package org.jeecg.modules.demo.test4.mapper;

import java.util.List;
import org.jeecg.modules.demo.test4.entity.SysUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: sys_user
 * @Author: jeecg-boot
 * @Date:   2024-10-31
 * @Version: V1.0
 */
public interface SysUsersMapper extends BaseMapper<SysUsers> {

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
   * @return List<SysUsers>
   */
	public List<SysUsers> selectByMainId(@Param("mainId") String mainId);
}
