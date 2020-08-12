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
import com.fc.test.mapper.auto.ThUserRelationGroupMapper;
import com.fc.test.model.auto.ThUserRelationGroup;
import com.fc.test.model.auto.ThUserRelationGroupExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThUserRelationGroupService
 * @Title: ThUserRelationGroupService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-07 22:16:02  
 **/
@Service
public class ThUserRelationGroupService implements BaseService<ThUserRelationGroup, ThUserRelationGroupExample>{
	@Autowired
	private ThUserRelationGroupMapper thUserRelationGroupMapper;
	
      	   	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThUserRelationGroup> list(Tablepar tablepar,String searchText){
	        ThUserRelationGroupExample testExample=new ThUserRelationGroupExample();
	        testExample.setOrderByClause("gp.id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	//testExample.createCriteria().andGorupIdLike("%"+searchText+"%");
	        	testExample.createCriteria();
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThUserRelationGroup> list= thUserRelationGroupMapper.selectByExample(testExample);
	        PageInfo<ThUserRelationGroup> pageInfo = new PageInfo<ThUserRelationGroup>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThUserRelationGroupExample example=new ThUserRelationGroupExample();
			example.createCriteria().andIdIn(stringB);
			return thUserRelationGroupMapper.deleteByExample(example);
			
				
	}
	
	
	
	
	public List<ThUserRelationGroup> selectByPrimaryuserid(String id) {
		Integer id1 = Integer.valueOf(id);
		return thUserRelationGroupMapper.selectByPrimaryuserid(id1);
		
	}
	
	@Override
	public ThUserRelationGroup selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thUserRelationGroupMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThUserRelationGroup record) {
		return thUserRelationGroupMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThUserRelationGroup record) {
				
		record.setId(null);
		
				
		return thUserRelationGroupMapper.insertSelective(record);
	}
	/**
	 * 判断是否有用户
	 */
	public void selectByPrimaryuser(ThUserRelationGroup thUserRelationGroup) {
		ThUserRelationGroup idk  = thUserRelationGroupMapper.selectByPrimaryuser(thUserRelationGroup);
		if(null != idk) {
			thUserRelationGroupMapper.deleteByPrimaryKey(idk.getId());
		}
	}
	
	
	public void deleteByPrimaryUser(Integer id) {
		thUserRelationGroupMapper.deleteByPrimaryUser(id);
	}
	/**
	 * 判断是否有用户
	 */
	public int selectByPrimaryuser1(ThUserRelationGroup thUserRelationGroup) {
		int type = 0;
		ThUserRelationGroup idk  = thUserRelationGroupMapper.selectByPrimaryuserALL(thUserRelationGroup);
		if(null != idk) {
			type = 1;
		}
		return type;
	}
	
	
	@Override
	public int updateByExampleSelective(ThUserRelationGroup record, ThUserRelationGroupExample example) {
		
		return thUserRelationGroupMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThUserRelationGroup record, ThUserRelationGroupExample example) {
		
		return thUserRelationGroupMapper.updateByExample(record, example);
	}

	@Override
	public List<ThUserRelationGroup> selectByExample(ThUserRelationGroupExample example) {
		
		return thUserRelationGroupMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThUserRelationGroupExample example) {
		
		return thUserRelationGroupMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThUserRelationGroupExample example) {
		
		return thUserRelationGroupMapper.deleteByExample(example);
	}
	
	public void delete(ThUserRelationGroup record) {
		
		thUserRelationGroupMapper.deleteByPrimaryKey(record.getId());
	}
	
	public int type(ThUserRelationGroup record) {
		
		int type = 0;
		
		ThUserRelationGroup idk =  thUserRelationGroupMapper.selectKeyType(record);
		if(null != idk) {
			type = 1;
		}
		return type;
	}
	/**
	 * 检查name
	 * @param thUserRelationGroup
	 * @return
	 */
	public int checkNameUnique(ThUserRelationGroup thUserRelationGroup){
		ThUserRelationGroupExample example=new ThUserRelationGroupExample();
		example.createCriteria().andGorupIdEqualTo(thUserRelationGroup.getGorupId());
		List<ThUserRelationGroup> list=thUserRelationGroupMapper.selectByExample(example);
		return list.size();
	}


}
