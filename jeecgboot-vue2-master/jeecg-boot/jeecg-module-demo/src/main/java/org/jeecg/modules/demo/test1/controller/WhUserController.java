package org.jeecg.modules.demo.test1.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.test1.entity.WhUser;
import org.jeecg.modules.demo.test1.service.IWhUserService;
import java.util.Date;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: wh用户表
 * @Author: jeecg-boot
 * @Date:   2024-10-23
 * @Version: V1.0
 */
@Slf4j
@Api(tags="wh用户表")
@RestController
@RequestMapping("/test1/whUser")
public class WhUserController extends JeecgController<WhUser, IWhUserService> {
	@Autowired
	private IWhUserService whUserService;
	
	/**
	 * 分页列表查询
	 *
	 * @param whUser
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "wh用户表-分页列表查询")
	@ApiOperation(value="wh用户表-分页列表查询", notes="wh用户表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(WhUser whUser,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<WhUser> queryWrapper = QueryGenerator.initQueryWrapper(whUser, req.getParameterMap());
		Page<WhUser> page = new Page<WhUser>(pageNo, pageSize);
		IPage<WhUser> pageList = whUserService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param whUser
	 * @return
	 */
	@AutoLog(value = "wh用户表-添加")
	@ApiOperation(value="wh用户表-添加", notes="wh用户表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody WhUser whUser) {
		whUserService.save(whUser);
		return Result.OK("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param whUser
	 * @return
	 */
	@AutoLog(value = "wh用户表-编辑")
	@ApiOperation(value="wh用户表-编辑", notes="wh用户表-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<?> edit(@RequestBody WhUser whUser) {
		whUserService.updateById(whUser);
		return Result.OK("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "wh用户表-通过id删除")
	@ApiOperation(value="wh用户表-通过id删除", notes="wh用户表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		whUserService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "wh用户表-批量删除")
	@ApiOperation(value="wh用户表-批量删除", notes="wh用户表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.whUserService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "wh用户表-通过id查询")
	@ApiOperation(value="wh用户表-通过id查询", notes="wh用户表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		WhUser whUser = whUserService.getById(id);
		return Result.OK(whUser);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param whUser
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, WhUser whUser) {
      return super.exportXls(request, whUser, WhUser.class, "wh用户表");
  }

  /**
   * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      return super.importExcel(request, response, WhUser.class);
  }

}
