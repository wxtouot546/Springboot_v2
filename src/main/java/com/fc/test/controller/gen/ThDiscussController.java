package com.fc.test.controller.gen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseController;
import com.fc.test.common.domain.AjaxResult;
import com.fc.test.model.auto.ThDiscuss;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ThDiscussService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "")
@Controller
@RequestMapping("/ThDiscussController")
public class ThDiscussController extends BaseController{
	
	private String prefix = "gen/thDiscuss";
	@Autowired
	private ThDiscussService thDiscussService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:thDiscuss:view")
    public String view(ModelMap model)
    {	
		String str="";
		setTitle(model, new TitleVo("列表", str+"评论", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:thDiscuss:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<ThDiscuss> page=thDiscussService.list(tablepar,searchText) ; 
		TableSplitResult<ThDiscuss> result=new TableSplitResult<ThDiscuss>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	
	/**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
	/**
     * 新增
     */
	//@Log(title = "新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:thDiscuss:add")
	@ResponseBody
	public AjaxResult add(ThDiscuss thDiscuss){
   		thDiscuss.setCreateTime(new Date());
		int b=thDiscussService.insertSelective(thDiscuss);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
   	
   	
   	/**
   	 * 新增
   	 */
   	//@Log(title = "新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
   	@PostMapping("/addUsers")
   	@ResponseBody
   	public AjaxResult add(HttpServletRequest request, MultipartFile input,HttpServletResponse rsp) throws IOException{
   		request.setCharacterEncoding("UTF-8");
		rsp.setContentType("text/html;charset=UTF-8");
		CommonsMultipartFile cFile = (CommonsMultipartFile) input;
		DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
		InputStream is = fileItem.getInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i < rowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(0);
			cell.setCellType(XSSFCell.CELL_TYPE_STRING);
			String cellStr = cell.getStringCellValue();
			System.out.println(cellStr);
			XSSFCell cell1 = row.getCell(1);
			cell1.setCellType(XSSFCell.CELL_TYPE_STRING);
			String cellStr1 = cell1.getStringCellValue();
			
			XSSFCell cell2 = row.getCell(2);
			cell2.setCellType(XSSFCell.CELL_TYPE_STRING);
			String cellStr2 = cell2.getStringCellValue();
			
			XSSFCell cell3 = row.getCell(3);
			cell3.setCellType(XSSFCell.CELL_TYPE_STRING);
			String cellStr3 = cell3.getStringCellValue();
			
		}
   			return success();
   		/*}else{
   			return error();
   		}*/
   	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:thDiscuss:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=thDiscussService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 检查Name
	 * @param tsysUser
	 * @return
	 */
	@ApiOperation(value = "检查Name唯一", notes = "检查Name唯一")
	@PostMapping("/checkNameUnique")
	@ResponseBody
	public int checkNameUnique(ThDiscuss thDiscuss){
		int b=thDiscussService.checkNameUnique(thDiscuss);
		if(b>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("ThDiscuss", thDiscussService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:thDiscuss:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThDiscuss record)
    {
    	record.setUpdateTime(new Date());
        return toAjax(thDiscussService.updateByPrimaryKeySelective(record));
    }

    
    /**
   	 * 根据主键查询
   	 * 
   	 * @param id
   	 * @param mmap
   	 * @return
   	 */
   	@ApiOperation(value = "根据id查询唯一", notes = "根据id查询唯一")
   	@PostMapping("/get/{id}")
   	public ThDiscuss edit(@PathVariable("id") String id) {
   		return thDiscussService.selectByPrimaryKey(id);
   	}
    

	
}
