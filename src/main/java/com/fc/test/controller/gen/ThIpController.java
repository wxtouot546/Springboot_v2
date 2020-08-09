package com.fc.test.controller.gen;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.fc.test.common.base.BaseController;
import com.fc.test.common.domain.AjaxResult;
import com.fc.test.model.auto.ThIp;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ThIpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "")
@Controller
@RequestMapping("/ThIpController")
public class ThIpController extends BaseController{
	
	private String prefix = "gen/thIp";
	@Autowired
	private ThIpService thIpService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:thIp:view")
    public String view(ModelMap model)
    {	
		String str="";
		setTitle(model, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:thIp:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<ThIp> page=thIpService.list(tablepar,searchText) ; 
		TableSplitResult<ThIp> result=new TableSplitResult<ThIp>(page.getPageNum(), page.getTotal(), page.getList()); 
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
	@RequiresPermissions("gen:thIp:add")
	@ResponseBody
	public AjaxResult add(ThIp thIp){
		
   		// 动态ip 还没开发 先设置null
   		thIp.setDateSource(null);
		if(null == thIp.getIp() || thIp.getIp().trim() == "") {
			// 如果不填返回错误
			return shibai("ip地址为必填项！不能不填");
		}
		// 如果状态为空 那么就填0（正常）
		if(null == thIp.getStatus()) {
			thIp.setStatus('0');
		}
		// 如果类型为空 那么就填0（静态）
		if(null == thIp.getType()) {
			thIp.setType('0');
		}
		thIp.setCreateTime(new Date());
		int b=thIpService.insertSelective(thIp);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:thIp:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=thIpService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(ThIp thIp){
		int b=thIpService.checkNameUnique(thIp);
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
        mmap.put("ThIp", thIpService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:thIp:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThIp record)
    {
    	// 动态ip 还没开发 先设置null
    	record.setDateSource(null);
		if(null == record.getIp() || record.getIp().trim() == "") {
			// 如果不填返回错误
			return shibai("ip地址为必填项！不能不填");
		}
		// 如果状态为空 那么就填0（正常）
		if(null == record.getStatus()) {
			record.setStatus('0');
		}
		// 如果类型为空 那么就填0（静态）
		if(null == record.getType()) {
			record.setType('0');
		}
		record.setUpdateTime(new Date());
        return toAjax(thIpService.updateByPrimaryKeySelective(record));
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
   	public ThIp edit(@PathVariable("id") String id) {
   		return thIpService.selectByPrimaryKey(id);
   	}
    

	
}
