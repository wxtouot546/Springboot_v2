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
import com.fc.test.model.auto.ThUser;
import com.fc.test.model.auto.ThUserGroup;
import com.fc.test.model.auto.ThUserRelationGroup;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ThUserGroupService;
import com.fc.test.service.ThUserRelationGroupService;
import com.fc.test.service.ThUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "")
@Controller
@RequestMapping("/ThUserRelationGroupController")
public class ThUserRelationGroupController extends BaseController{
	
	private String prefix = "gen/thUserRelationGroup";
	@Autowired
	private ThUserRelationGroupService thUserRelationGroupService;
	@Autowired
	private ThUserService thUserService;
	@Autowired
	private ThUserGroupService thUserGroupService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:thUserRelationGroup:view")
    public String view(ModelMap model)
    {	
		String str="";
		setTitle(model, new TitleVo("列表", str+"用户组分配用户", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:thUserRelationGroup:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText){
		PageInfo<ThUserRelationGroup> page=thUserRelationGroupService.list(tablepar,searchText) ; 
		TableSplitResult<ThUserRelationGroup> result=new TableSplitResult<ThUserRelationGroup>(page.getPageNum(), page.getTotal(), page.getList()); 
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
    	ThUser record = new ThUser();
    	List<ThUser> thlist =  thUserService.selectAll(record);
    	
    	// 如果不为空就看看
    	if(null != thlist && thlist.size() != 0) {
    		List<ThUserRelationGroup>  gplist = thUserRelationGroupService.selectByPrimaryuserid(thlist.get(0).getId()+"");
    		if(null != gplist && gplist.size() != 0) {
    			String groupIds = "";
    			int len = 1;
    			for (int s = 0; s < gplist.size(); s++,len++) {
    				if(len == gplist.size()){
    					groupIds += gplist.get(s).getGorupId();
    				}else{
    					groupIds += gplist.get(s).getGorupId() +",";
    				}
    			}
    			if(!groupIds.equals("")) {
    				modelMap.addAttribute("groupIds",groupIds);
    			}
    		}
    	}
    	modelMap.addAttribute("thlist",thlist);
    	modelMap.addAttribute("listgroup",listgroup);
        return prefix + "/add";
    }
    
   	@PostMapping("/chaek")
   	@ResponseBody
   	public String chaek(ThUserRelationGroup thUserRelationGroup) {
   	// 如果不为空就看看
	List<ThUserRelationGroup>  gplist = thUserRelationGroupService.selectByPrimaryuserid(thUserRelationGroup.getUserId()+"");
	String groupIds = "";
	if(null != gplist && gplist.size() != 0) {
		int len = 1;
		for (int s = 0; s < gplist.size(); s++,len++) {
			if(len == gplist.size()){
				groupIds += gplist.get(s).getGorupId();
			}else{
				groupIds += gplist.get(s).getGorupId() +",";
			}
		}
	}
   		
   		
   		return groupIds;
   	}
    
	
	/**
     * 新增
     */
	//@Log(title = "新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:thUserRelationGroup:add")
	@ResponseBody
	public AjaxResult add(ThUserRelationGroup thUserRelationGroup){
   		String message = null;
   		if(null == thUserRelationGroup.getUserId()) {
   			message = "用户不能为空";
   		}
   		if(null != message) {
   			return shibai(message);
   		}
   		// 先删除所有记录
   		thUserRelationGroupService.deleteByPrimaryUser(thUserRelationGroup.getUserId());
   		// 因为是逗号分割  所以要拿出来循环一遍
   		String val = thUserRelationGroup.getGroupName();
   		String[] groupId = val.split(",");
   		for(int i = 0; i < groupId.length; i++) {
   			thUserRelationGroup.setGorupId(Integer.parseInt(groupId[i]));
   	   		// 设置创建时间
   	   		thUserRelationGroup.setCreateTime(new Date());
   			thUserRelationGroupService.insertSelective(thUserRelationGroup);
   		}
		return success();
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:thUserRelationGroup:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=thUserRelationGroupService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(ThUserRelationGroup thUserRelationGroup){
		int b=thUserRelationGroupService.checkNameUnique(thUserRelationGroup);
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
        mmap.put("ThUserRelationGroup", thUserRelationGroupService.selectByPrimaryKey(id));
        // 查询用户组信息
    	ThUserGroup records = new ThUserGroup();
    	List<ThUserGroup> listgroup = thUserGroupService.selectAll(records);
    	// 查询用户信息
    	ThUser record = new ThUser();
    	List<ThUser> thlist =  thUserService.selectAll(record);
    	mmap.addAttribute("thlist",thlist);
    	mmap.addAttribute("listgroup",listgroup);
        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:thUserRelationGroup:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThUserRelationGroup record)
    {	
    	// 判断是否存在
    	int type = thUserRelationGroupService.type(record);
    	if(type != 0) {
    		return shibai("用户存在请重新选择");
    	}
    	// 只要保存就吧原来的删掉
    	thUserRelationGroupService.delete(record);
    	// 设置创建时间
    	record.setCreateTime(new Date());
		int b=thUserRelationGroupService.insertSelective(record);
		if(b>0){
			return success();
		}else{
			return error();
		}
   		
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
   	public ThUserRelationGroup edit(@PathVariable("id") String id) {
   		return thUserRelationGroupService.selectByPrimaryKey(id);
   	}
    

	
}
