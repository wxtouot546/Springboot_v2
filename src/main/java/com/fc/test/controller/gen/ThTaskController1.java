package com.fc.test.controller.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.fc.test.model.auto.ThDiscussGroup;
import com.fc.test.model.auto.ThDiscussRelationGroup;
import com.fc.test.model.auto.ThIp;
import com.fc.test.model.auto.ThTask;
import com.fc.test.model.auto.ThUser;
import com.fc.test.model.auto.ThUserGroup;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ThDiscussGroupService;
import com.fc.test.service.ThDiscussRelationGroupService;
import com.fc.test.service.ThIpService;
import com.fc.test.service.ThTaskService;
import com.fc.test.service.ThUserGroupService;
import com.fc.test.service.ThUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "")
@Controller
@RequestMapping("/ThTaskController1")
public class ThTaskController1 extends BaseController{
	
	private String prefix = "gen/thTask1";
	@Autowired
	private ThTaskService thTaskService;
	@Autowired
	private ThUserGroupService thUserGroupService;
	@Autowired
	private ThUserService thUserService;
	@Autowired
	private ThIpService thIpService;
	@Autowired
	private ThDiscussRelationGroupService thDiscussRelationGroupService;
	@Autowired
	private ThDiscussGroupService thDiscussGroupService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:thTask:view1")
    public String view(ModelMap model)
    {	
		String str="";
		setTitle(model, new TitleVo("列表", str+"顶贴", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:thTask:list1")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<ThTask> page=thTaskService.list(tablepar,searchText) ; 
		TableSplitResult<ThTask> result=new TableSplitResult<ThTask>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	
	/**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
    	// 查询用户组信息
    	ThUserGroup records = new ThUserGroup();
    	List<ThUserGroup> listgroup = thUserGroupService.selectAll(records);
    	// 查询用户信息
    	
    	List<ThUser> thlist =  new ArrayList<>();
    	if(null != listgroup && listgroup.size() != 0) {
			thlist = thUserService.selectAllbygrop(listgroup.get(0).getId());
    	}
    	
    	// 查询评论组
    	ThDiscussGroup thdis = new ThDiscussGroup();
    	List<ThDiscussGroup> thList = thDiscussGroupService.listAll(thdis);
    	modelMap.addAttribute("thList",thList);
    	modelMap.addAttribute("thlist",thlist);
    	modelMap.addAttribute("listgroup",listgroup);
        return prefix + "/add";
    }
	
	/**
     * 新增
     */
	//@Log(title = "新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:thTask:add1")
	@ResponseBody
	public AjaxResult add(ThTask thTask){
   		if(thTask.getType().equals('3')) {
   			//  回复间隔开始
   	   		if(null == thTask.getStart()) {
   	   			thTask.setStart(1);
   	   		}
   		}else {
   			//  回复间隔开始
   	   		if(null == thTask.getStart()) {
   	   			thTask.setStart(0);
   	   		}
   	   		//  回复间隔结束
   	   		if(null == thTask.getEnd()) {
   	   			thTask.setEnd(0);
   	   		}
   		}
   		//  如果回复数量没有填 那么默认是1
   		if(null == thTask.getNumber()) {
   			thTask.setNumber(1);
   		}
   		thTask.setCreateTime(new Date());
		int b=thTaskService.insertSelective(thTask);
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
	@RequiresPermissions("gen:thTask:remove1")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=thTaskService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(ThTask thTask){
		int b=thTaskService.checkNameUnique(thTask);
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
		// 查询用户组信息
    	ThUserGroup records = new ThUserGroup();
    	List<ThUserGroup> listgroup = thUserGroupService.selectAll(records);
    	// 查询用户信息
    	List<ThUser> thlist =  new ArrayList<>();
    	ThTask tk = thTaskService.selectByPrimaryKey(id);
    	if(tk.getUserGroupId() != null) {
    		thlist = thUserService.selectAllbygrop(tk.getUserGroupId());
    	}
    	// 查询评论组
    	ThDiscussGroup thdis = new ThDiscussGroup();
    	List<ThDiscussGroup> thList = thDiscussGroupService.listAll(thdis);
    	mmap.addAttribute("thList",thList);
    	mmap.addAttribute("thlist",thlist);
    	mmap.addAttribute("listgroup",listgroup);
    	
        mmap.put("ThTask", tk);

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:thTask:edit1")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThTask record)
    {
        return toAjax(thTaskService.updateByPrimaryKeySelective(record));
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
   	public ThTask edit(@PathVariable("id") String id) {
   		return thTaskService.selectByPrimaryKey(id);
   	}
    

	
}
