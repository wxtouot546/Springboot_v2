package com.fc.test.service;

import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.ConvertUtil;
import com.fc.test.mapper.auto.ThUserMapper;
import com.fc.test.model.auto.ThUser;
import com.fc.test.model.auto.ThUserExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThUserService
 * @Title: ThUserService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-07 20:38:44  
 **/
@Service
public class ThUserService implements BaseService<ThUser, ThUserExample>{
	@Autowired
	private ThUserMapper thUserMapper;
	
      	   	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThUser> list(Tablepar tablepar,String searchText){
	        Map<String,Object> map = new HashMap<String,Object>();
	        if(null != searchText && searchText != "") {
	        	map.put("searchText", searchText);
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThUser> list= thUserMapper.selectByu(map);
	        PageInfo<ThUser> pageInfo = new PageInfo<ThUser>(list);
	        return  pageInfo;
	 }
	 
	 public List<ThUser> selectAll(ThUser record){
		 return thUserMapper.selectAll(record);
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThUserExample example=new ThUserExample();
			example.createCriteria().andIdIn(stringB);
			return thUserMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThUser selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thUserMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThUser record) {
		return thUserMapper.updateByPrimaryKeySelective(record);
	}
	
	public boolean selectAllbyName(ThUser record){
		boolean type = false;
		List<ThUser> list = thUserMapper.selectAllbyName(record);
		if(null == list || list.size() > 0) {
			type = true;
		}
		return  type;
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThUser record) {
				
		record.setId(null);
		
				
		return thUserMapper.insertSelective(record);
	}
	
	public List<ThUser> selectAllbygrop(Integer id){
		return thUserMapper.selectAllbygrop(id);
	}
	
	
	@Override
	public int updateByExampleSelective(ThUser record, ThUserExample example) {
		
		return thUserMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThUser record, ThUserExample example) {
		
		return thUserMapper.updateByExample(record, example);
	}

	@Override
	public List<ThUser> selectByExample(ThUserExample example) {
		
		return thUserMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThUserExample example) {
		
		return thUserMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThUserExample example) {
		
		return thUserMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thUser
	 * @return
	 */
	public int checkNameUnique(ThUser thUser){
		ThUserExample example=new ThUserExample();
		example.createCriteria().andUserIdEqualTo(thUser.getUserId());
		List<ThUser> list=thUserMapper.selectByExample(example);
		return list.size();
	}


}
