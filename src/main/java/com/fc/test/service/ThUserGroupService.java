package com.fc.test.service;

import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.StrUtil;
import com.fc.test.common.base.BaseService;
import com.fc.test.common.support.ConvertUtil;
import com.fc.test.mapper.auto.ThUserGroupMapper;
import com.fc.test.model.auto.ThUserGroup;
import com.fc.test.model.auto.ThUserGroupExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThUserGroupService
 * @Title: ThUserGroupService.java 
 * @Package com.fc.test.service 
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2020-08-07 21:42:31  
 **/
@Service
public class ThUserGroupService implements BaseService<ThUserGroup, ThUserGroupExample>{
	@Autowired
	private ThUserGroupMapper thUserGroupMapper;
	
      	   	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThUserGroup> list(Tablepar tablepar,String searchText){
	        ThUserGroupExample testExample=new ThUserGroupExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	testExample.createCriteria().andUserGroupNameLike("%"+searchText+"%");
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThUserGroup> list= thUserGroupMapper.selectByExample(testExample);
	        PageInfo<ThUserGroup> pageInfo = new PageInfo<ThUserGroup>(list);
	        return  pageInfo;
	 }
	 
	 public List<ThUserGroup> selectAll(ThUserGroup records){
		 List<ThUserGroup> list = thUserGroupMapper.selectAll(records);
		 return  list;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThUserGroupExample example=new ThUserGroupExample();
			example.createCriteria().andIdIn(stringB);
			return thUserGroupMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThUserGroup selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thUserGroupMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThUserGroup record) {
		return thUserGroupMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThUserGroup record) {
				
		record.setId(null);
		
				
		return thUserGroupMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThUserGroup record, ThUserGroupExample example) {
		
		return thUserGroupMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThUserGroup record, ThUserGroupExample example) {
		
		return thUserGroupMapper.updateByExample(record, example);
	}

	@Override
	public List<ThUserGroup> selectByExample(ThUserGroupExample example) {
		
		return thUserGroupMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThUserGroupExample example) {
		
		return thUserGroupMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThUserGroupExample example) {
		
		return thUserGroupMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thUserGroup
	 * @return
	 */
	public int checkNameUnique(ThUserGroup thUserGroup){
		ThUserGroupExample example=new ThUserGroupExample();
		example.createCriteria().andUserGroupNameEqualTo(thUserGroup.getUserGroupName());
		List<ThUserGroup> list=thUserGroupMapper.selectByExample(example);
		return list.size();
	}


}
