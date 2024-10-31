package org.jeecg.modules.demo.test4.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.UnsupportedEncodingException;

/**
 * @Description: sys_user
 * @Author: jeecg-boot
 * @Date:   2024-10-31
 * @Version: V1.0
 */
@ApiModel(value="sys_user对象", description="sys_user")
@Data
@TableName("sys_user")
public class SysUsers implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键id")
    private java.lang.String id;
	/**登录账号*/
	@Excel(name = "登录账号", width = 15)
    @ApiModelProperty(value = "登录账号")
    private java.lang.String username;
	/**真实姓名*/
	@Excel(name = "真实姓名", width = 15)
    @ApiModelProperty(value = "真实姓名")
    private java.lang.String realname;
	/**密码*/
	@Excel(name = "密码", width = 15)
    @ApiModelProperty(value = "密码")
    private java.lang.String password;
	/**md5密码盐*/
	@Excel(name = "md5密码盐", width = 15)
    @ApiModelProperty(value = "md5密码盐")
    private java.lang.String salt;
	/**头像*/
	@Excel(name = "头像", width = 15)
    @ApiModelProperty(value = "头像")
    private java.lang.String avatar;
	/**生日*/
	@Excel(name = "生日", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private java.util.Date birthday;
	/**性别(0-默认未知,1-男,2-女)*/
	@Excel(name = "性别(0-默认未知,1-男,2-女)", width = 15)
    @ApiModelProperty(value = "性别(0-默认未知,1-男,2-女)")
    private java.lang.Integer sex;
	/**电子邮件*/
	@Excel(name = "电子邮件", width = 15)
    @ApiModelProperty(value = "电子邮件")
    private java.lang.String email;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    private java.lang.String phone;
	/**登录会话的机构编码*/
	@Excel(name = "登录会话的机构编码", width = 15)
    @ApiModelProperty(value = "登录会话的机构编码")
    private java.lang.String orgCode;
	/**性别(1-正常,2-冻结)*/
	@Excel(name = "性别(1-正常,2-冻结)", width = 15)
    @ApiModelProperty(value = "性别(1-正常,2-冻结)")
    private java.lang.Integer status;
	/**删除状态(0-正常,1-已删除)*/
	@Excel(name = "删除状态(0-正常,1-已删除)", width = 15)
    @ApiModelProperty(value = "删除状态(0-正常,1-已删除)")
    @TableLogic
    private java.lang.Integer delFlag;
	/**第三方登录的唯一标识*/
	@Excel(name = "第三方登录的唯一标识", width = 15)
    @ApiModelProperty(value = "第三方登录的唯一标识")
    private java.lang.String thirdId;
	/**第三方类型*/
	@Excel(name = "第三方类型", width = 15)
    @ApiModelProperty(value = "第三方类型")
    private java.lang.String thirdType;
	/**同步工作流引擎(1-同步,0-不同步)*/
	@Excel(name = "同步工作流引擎(1-同步,0-不同步)", width = 15)
    @ApiModelProperty(value = "同步工作流引擎(1-同步,0-不同步)")
    private java.lang.Integer activitiSync;
	/**工号，唯一键*/
	@Excel(name = "工号，唯一键", width = 15)
    @ApiModelProperty(value = "工号，唯一键")
    private java.lang.String workNo;
	/**职务，关联职务表*/
	@Excel(name = "职务，关联职务表", width = 15)
    @ApiModelProperty(value = "职务，关联职务表")
    private java.lang.String post;
	/**座机号*/
	@Excel(name = "座机号", width = 15)
    @ApiModelProperty(value = "座机号")
    private java.lang.String telephone;
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
	/**身份（1普通成员 2上级）*/
	@Excel(name = "身份（1普通成员 2上级）", width = 15)
    @ApiModelProperty(value = "身份（1普通成员 2上级）")
    private java.lang.Integer userIdentity;
	/**负责部门*/
	@Excel(name = "负责部门", width = 15)
    @ApiModelProperty(value = "负责部门")
    private java.lang.String departIds;
	/**多租户标识*/
	@Excel(name = "多租户标识", width = 15)
    @ApiModelProperty(value = "多租户标识")
    private java.lang.String relTenantIds;
	/**设备ID*/
	@Excel(name = "设备ID", width = 15)
    @ApiModelProperty(value = "设备ID")
    private java.lang.String clientId;
	/**角色id*/
    @ApiModelProperty(value = "角色id")
    private java.lang.String roleId;
}
