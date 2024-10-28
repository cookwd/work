package org.jeecg.modules.demo.test2.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.test2.entity.WhEmp;
import org.jeecg.modules.demo.test2.entity.WhDepartment;
import org.jeecg.modules.demo.test2.vo.WhDepartmentPage;
import org.jeecg.modules.demo.test2.service.IWhDepartmentService;
import org.jeecg.modules.demo.test2.service.IWhEmpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: wh部门
 * @Author: jeecg-boot
 * @Date:   2024-10-24
 * @Version: V1.0
 */
@Api(tags="wh部门")
@RestController
@RequestMapping("/test2/whDepartment")
@Slf4j
public class WhDepartmentController {
	@Autowired
	private IWhDepartmentService whDepartmentService;
	@Autowired
	private IWhEmpService whEmpService;
	
	/**
	 * 分页列表查询
	 *
	 * @param whDepartment
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "wh部门-分页列表查询")
	@ApiOperation(value="wh部门-分页列表查询", notes="wh部门-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<WhDepartment>> queryPageList(WhDepartment whDepartment,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<WhDepartment> queryWrapper = QueryGenerator.initQueryWrapper(whDepartment, req.getParameterMap());
		Page<WhDepartment> page = new Page<WhDepartment>(pageNo, pageSize);
		IPage<WhDepartment> pageList = whDepartmentService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param whDepartmentPage
	 * @return
	 */
	@AutoLog(value = "wh部门-添加")
	@ApiOperation(value="wh部门-添加", notes="wh部门-添加")
    //@RequiresPermissions("org.jeecg.modules.demo:wh_department:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody WhDepartmentPage whDepartmentPage) {
		WhDepartment whDepartment = new WhDepartment();
		BeanUtils.copyProperties(whDepartmentPage, whDepartment);
		whDepartmentService.saveMain(whDepartment, whDepartmentPage.getWhEmpList());
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param whDepartmentPage
	 * @return
	 */
	@AutoLog(value = "wh部门-编辑")
	@ApiOperation(value="wh部门-编辑", notes="wh部门-编辑")
    //@RequiresPermissions("org.jeecg.modules.demo:wh_department:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody WhDepartmentPage whDepartmentPage) {
		WhDepartment whDepartment = new WhDepartment();
		BeanUtils.copyProperties(whDepartmentPage, whDepartment);
		WhDepartment whDepartmentEntity = whDepartmentService.getById(whDepartment.getId());
		if(whDepartmentEntity==null) {
			return Result.error("未找到对应数据");
		}
		whDepartmentService.updateMain(whDepartment, whDepartmentPage.getWhEmpList());
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "wh部门-通过id删除")
	@ApiOperation(value="wh部门-通过id删除", notes="wh部门-通过id删除")
    //@RequiresPermissions("org.jeecg.modules.demo:wh_department:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		whDepartmentService.delMain(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "wh部门-批量删除")
	@ApiOperation(value="wh部门-批量删除", notes="wh部门-批量删除")
    //@RequiresPermissions("org.jeecg.modules.demo:wh_department:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.whDepartmentService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "wh部门-通过id查询")
	@ApiOperation(value="wh部门-通过id查询", notes="wh部门-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<WhDepartment> queryById(@RequestParam(name="id",required=true) String id) {
		WhDepartment whDepartment = whDepartmentService.getById(id);
		if(whDepartment==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(whDepartment);

	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "wh员工通过主表ID查询")
	@ApiOperation(value="wh员工主表ID查询", notes="wh员工-通主表ID查询")
	@GetMapping(value = "/queryWhEmpByMainId")
	public Result<List<WhEmp>> queryWhEmpListByMainId(@RequestParam(name="id",required=true) String id) {
		List<WhEmp> whEmpList = whEmpService.selectByMainId(id);
		return Result.OK(whEmpList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param whDepartment
    */
    //@RequiresPermissions("org.jeecg.modules.demo:wh_department:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, WhDepartment whDepartment) {
      // Step.1 组装查询条件查询数据
      QueryWrapper<WhDepartment> queryWrapper = QueryGenerator.initQueryWrapper(whDepartment, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

      //配置选中数据查询条件
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      //Step.2 获取导出数据
      List<WhDepartment> whDepartmentList = whDepartmentService.list(queryWrapper);

      // Step.3 组装pageList
      List<WhDepartmentPage> pageList = new ArrayList<WhDepartmentPage>();
      for (WhDepartment main : whDepartmentList) {
          WhDepartmentPage vo = new WhDepartmentPage();
          BeanUtils.copyProperties(main, vo);
          List<WhEmp> whEmpList = whEmpService.selectByMainId(main.getId());
          vo.setWhEmpList(whEmpList);
          pageList.add(vo);
      }

      // Step.4 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "wh部门列表");
      mv.addObject(NormalExcelConstants.CLASS, WhDepartmentPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("wh部门数据", "导出人:"+sysUser.getRealname(), "wh部门"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
    }

    /**
    * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    //@RequiresPermissions("org.jeecg.modules.demo:wh_department:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          // 获取上传文件对象
          MultipartFile file = entity.getValue();
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<WhDepartmentPage> list = ExcelImportUtil.importExcel(file.getInputStream(), WhDepartmentPage.class, params);
              for (WhDepartmentPage page : list) {
                  WhDepartment po = new WhDepartment();
                  BeanUtils.copyProperties(page, po);
                  whDepartmentService.saveMain(po, page.getWhEmpList());
              }
              return Result.OK("文件导入成功！数据行数:" + list.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.OK("文件导入失败！");
    }

}
