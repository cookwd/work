package org.jeecg.modules.demo.test2.vo;

import java.util.List;
import org.jeecg.modules.demo.test2.entity.WhDepartment;
import org.jeecg.modules.demo.test2.entity.WhEmp;
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
 * @Description: wh部门
 * @Author: jeecg-boot
 * @Date:   2024-10-24
 * @Version: V1.0
 */
@Data
@ApiModel(value="wh_departmentPage对象", description="wh部门")
public class WhDepartmentPage {

	/**主键*/
	@ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
	@ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
	@ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**部门名称*/
	@Excel(name = "部门名称", width = 15)
	@ApiModelProperty(value = "部门名称")
    private java.lang.String departname;
	/**描述*/
	@Excel(name = "描述", width = 15)
	@ApiModelProperty(value = "描述")
    private java.lang.String description;

	@ExcelCollection(name="wh员工")
	@ApiModelProperty(value = "wh员工")
	private List<WhEmp> whEmpList;

}
