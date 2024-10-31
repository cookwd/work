package org.jeecg.modules.demo.test4.vo;

import java.util.List;
import org.jeecg.modules.demo.test4.entity.SysRoles;
import org.jeecg.modules.demo.test4.entity.SysUsers;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: sys_role
 * @Author: jeecg-boot
 * @Date:   2024-10-31
 * @Version: V1.0
 */
@Data
@ApiModel(value="sys_rolePage对象", description="sys_role")
public class SysRolesPage {

	/**主键id*/
	@ApiModelProperty(value = "主键id")
    private java.lang.String id;
	/**角色名称*/
	@Excel(name = "角色名称", width = 15)
	@ApiModelProperty(value = "角色名称")
    private java.lang.String roleName;
	/**角色编码*/
	@Excel(name = "角色编码", width = 15)
	@ApiModelProperty(value = "角色编码")
    private java.lang.String roleCode;
	/**描述*/
	@Excel(name = "描述", width = 15)
	@ApiModelProperty(value = "描述")
    private java.lang.String description;
	/**创建人*/
	@ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新人*/
	@ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
	/**userId*/
	@Excel(name = "userId", width = 15)
	@ApiModelProperty(value = "userId")
    private java.lang.String userId;

	@ExcelCollection(name="sys_user")
	@ApiModelProperty(value = "sys_user")
	private List<SysUsers> sysUsersList;

}
