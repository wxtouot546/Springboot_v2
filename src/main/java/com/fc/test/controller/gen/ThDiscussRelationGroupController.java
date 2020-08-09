package com.fc.test.controller.gen;

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
import com.fc.test.model.auto.ThDiscuss;
import com.fc.test.model.auto.ThDiscussGroup;
import com.fc.test.model.auto.ThDiscussRelationGroup;
import com.fc.test.model.auto.ThUser;
import com.fc.test.model.auto.ThUserGroup;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ThDiscussGroupService;
import com.fc.test.service.ThDiscussRelationGroupService;
import com.fc.test.service.ThDiscussService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "")
@Controller
@RequestMapping("/ThDiscussRelationGroupController")
public class ThDiscussRelationGroupController extends BaseController{
	
	private String prefix = "gen/thDiscussRelationGroup";
	@Autowired
	private ThDiscussRelationGroupService thDiscussRelationGroupService;
	@Autowired
	private ThDiscussService thDiscussService;
	@Autowired
	private ThDiscussGroupService thDiscussGroupService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:thDiscussRelationGroup:view")
    public String view(ModelMap model)
    {	
		String str="";
		setTitle(model, new TitleVo("列表", str+"评论组管理评论", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:thDiscussRelationGroup:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<ThDiscussRelationGroup> page=thDiscussRelationGroupService.list(tablepar,searchText) ; 
		TableSplitResult<ThDiscussRelationGroup> result=new TableSplitResult<ThDiscussRelationGroup>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	
	/**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
    	// 查询评论信息
    	ThDiscuss records = new ThDiscuss();
    	List<ThDiscuss> listth = thDiscussService.selectByALL(records);
    	// 查询评论组信息
    	ThDiscussGroup record = new ThDiscussGroup();
    	List<ThDiscussGroup> listgroup = thDiscussGroupService.selectAll(record);
    	modelMap.addAttribute("listth",listth);
    	modelMap.addAttribute("listgroup",listgroup);
        return prefix + "/add";
    }
	
	/**
     * 新增
     */
	//@Log(title = "新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:thDiscussRelationGroup:add")
	@ResponseBody
	public AjaxResult add(ThDiscussRelationGroup thDiscussRelationGroup){
   		thDiscussRelationGroup.setCreateTime(new Date());
		int b=thDiscussRelationGroupService.insertSelective(thDiscussRelationGroup);
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
	@RequiresPermissions("gen:thDiscussRelationGroup:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=thDiscussRelationGroupService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(ThDiscussRelationGroup thDiscussRelationGroup){
		int b=thDiscussRelationGroupService.checkNameUnique(thDiscussRelationGroup);
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
		
		// 查询评论信息
    	ThDiscuss records = new ThDiscuss();
    	List<ThDiscuss> listth = thDiscussService.selectByALL(records);
    	// 查询评论组信息
    	ThDiscussGroup record = new ThDiscussGroup();
    	List<ThDiscussGroup> listgroup = thDiscussGroupService.selectAll(record);
    	mmap.addAttribute("listth",listth);
    	mmap.addAttribute("listgroup",listgroup);
        mmap.put("ThDiscussRelationGroup", thDiscussRelationGroupService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:thDiscussRelationGroup:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThDiscussRelationGroup record)
    {
    	record.setUpdateTime(new Date());
        return toAjax(thDiscussRelationGroupService.updateByPrimaryKeySelective(record));
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
   	public ThDiscussRelationGroup edit(@PathVariable("id") String id) {
   		return thDiscussRelationGroupService.selectByPrimaryKey(id);
   	}
    

	
}
