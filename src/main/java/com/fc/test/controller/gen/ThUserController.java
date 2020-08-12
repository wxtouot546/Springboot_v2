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
import com.fc.test.model.auto.ThIp;
import com.fc.test.model.auto.ThUser;
import com.fc.test.model.auto.ThUserGroup;
import com.fc.test.model.custom.TableSplitResult;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.model.custom.TitleVo;
import com.fc.test.service.ThIpService;
import com.fc.test.service.ThUserGroupService;
import com.fc.test.service.ThUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "")
@Controller
@RequestMapping("/ThUserController")
public class ThUserController extends BaseController{
	
	private String prefix = "gen/thUser";
	@Autowired
	private ThUserService thUserService;
	@Autowired
	private ThIpService thIpService;
	@Autowired
	private ThUserGroupService thUserGroupService;
	
	/**
	 * 分页跳转
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:thUser:view")
    public String view(ModelMap model)
    {	
		// 查询用户组信息
    	ThUserGroup records = new ThUserGroup();
    	List<ThUserGroup> listgroup = thUserGroupService.selectAll(records);
    	model.addAttribute("listgroup",listgroup);
		String str="";
		setTitle(model, new TitleVo("列表", str+"用户", true,"欢迎进入"+str+"页面", true, false));
        return prefix + "/list";
    }
	
	/**
	 * 分页查询
	 */
	//@Log(title = "集合查询", action = "111")
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@PostMapping("/list")
	@RequiresPermissions("gen:thUser:list")
	@ResponseBody
	public Object list(Tablepar tablepar,String searchText,String yonghuzu,String yongh){
		PageInfo<ThUser> page=thUserService.list(tablepar,searchText,yonghuzu,yongh) ; 
		TableSplitResult<ThUser> result=new TableSplitResult<ThUser>(page.getPageNum(), page.getTotal(), page.getList()); 
		return  result;
	}
	
	/**
     * 新增跳转
     */
    @ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {	
    	ThIp thIp = new ThIp();
    	List<ThIp> ipList = thIpService.selectAll(thIp);
    	modelMap.addAttribute("ipList",ipList);
        return prefix + "/add";
    }
	
	/**
     * 新增
     */
	//@Log(title = "新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:thUser:add")
	@ResponseBody
	public AjaxResult add(ThUser thUser){
   		thUser.setCreatTime(new Date());
   		// 如果密码没有填写，返回
   		if(null == thUser.getPassword() || "".equals(thUser.getPassword())) {
   			return shibai("密码为必填项！不能不填");
   		}
   		// 如果ip没有填写，返回
   		if(null == thUser.getIpId() || thUser.getIpId().trim() == "") {
   			return shibai("ip地址为必选项！如果没有IP地址请先添加ip");
   		}
   		// 如果状态没有填 那么默认是0
   		if(null == thUser.getIsdel()) {
   			thUser.setIsdel('0');
   		}
   		// 如果等级没有填 那么默认是0
   		if(null == thUser.getGrade()) {
   			thUser.setGrade(0);
   		}
   		// 如果分数没有填 那么默认是0
   		if(null == thUser.getFraction()) {
   			thUser.setFraction(0);
   		}
		int b=thUserService.insertSelective(thUser);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
   	/**
   	 * 用户组查询
   	 */
   	//@Log(title = "新增", action = "111")
   	@ApiOperation(value = "新增", notes = "新增")
   	@PostMapping("/type")
   	@ResponseBody
   	public AjaxResult type(String type){
   		List<ThUser> userlist = thUserService.selectAllbygrop(Integer.valueOf(type));
   		AjaxResult json = new AjaxResult();
        json.put("userlist", userlist);
        json.put("code", 200);
        return json;
   	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@PostMapping("/remove")
	@RequiresPermissions("gen:thUser:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=thUserService.deleteByPrimaryKey(ids);
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
	public int checkNameUnique(ThUser thUser){
		int b=thUserService.checkNameUnique(thUser);
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
		ThIp thIp = new ThIp();
    	List<ThIp> ipList = thIpService.selectAll(thIp);
    	mmap.addAttribute("ipList",ipList);
        mmap.put("ThUser", thUserService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "修改", action = "111")
    @ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:thUser:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ThUser record)
    {	
    	// 如果密码没有填写，返回
   		if(null == record.getPassword() || "".equals(record.getPassword())) {
   			return shibai("密码为必填项！不能不填");
   		}
   		// 如果ip没有填写，返回
   		if(null == record.getIpId() || record.getIpId().trim() == "") {
   			return shibai("ip地址为必选项！如果没有IP地址请先添加ip");
   		}
    	record.setUpdateTime(new Date());
    	// 如果状态没有填 那么默认是0
   		if(null == record.getIsdel()) {
   			record.setIsdel('0');
   		}
   		// 如果等级没有填 那么默认是0
   		if(null == record.getGrade()) {
   			record.setGrade(0);
   		}
   		// 如果分数没有填 那么默认是0
   		if(null == record.getFraction()) {
   			record.setFraction(0);
   		}
   		record.setCreatTime(new Date());
   		// 在这判断 如果用户名重复 那么就返回
   		boolean type = thUserService.selectAllbyName(record);
   		if(type) {
   			return shibai("用户重复，请重新输入！");
   		}
        return toAjax(thUserService.updateByPrimaryKeySelective(record));
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
   	public ThUser edit(@PathVariable("id") String id) {
   		return thUserService.selectByPrimaryKey(id);
   	}
    

	
}
