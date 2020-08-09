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
import com.fc.test.mapper.auto.ThDiscussRelationGroupMapper;
import com.fc.test.model.auto.ThDiscussRelationGroup;
import com.fc.test.model.auto.ThDiscussRelationGroupExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThDiscussRelationGroupService
 * @Title: ThDiscussRelationGroupService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:33:22  
 **/
@Service
public class ThDiscussRelationGroupService implements BaseService<ThDiscussRelationGroup, ThDiscussRelationGroupExample>{
	@Autowired
	private ThDiscussRelationGroupMapper thDiscussRelationGroupMapper;
	
      	   	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThDiscussRelationGroup> list(Tablepar tablepar,String searchText){
		 	ThDiscussRelationGroup testExample = new ThDiscussRelationGroup();
		 	if(null != searchText && searchText != "") {
		 		testExample.setSearchText(searchText);
		 	}
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThDiscussRelationGroup> list= thDiscussRelationGroupMapper.selectByExample1(testExample);
	        PageInfo<ThDiscussRelationGroup> pageInfo = new PageInfo<ThDiscussRelationGroup>(list);
	        return  pageInfo;
	 }
	 public List <ThDiscussRelationGroup> listAll(ThDiscussRelationGroup testExample){
		 List<ThDiscussRelationGroup> list= thDiscussRelationGroupMapper.selectByExample1(testExample);
		 return  list;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThDiscussRelationGroupExample example=new ThDiscussRelationGroupExample();
			example.createCriteria().andIdIn(stringB);
			return thDiscussRelationGroupMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThDiscussRelationGroup selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thDiscussRelationGroupMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThDiscussRelationGroup record) {
		return thDiscussRelationGroupMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThDiscussRelationGroup record) {
				
		record.setId(null);
		
				
		return thDiscussRelationGroupMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThDiscussRelationGroup record, ThDiscussRelationGroupExample example) {
		
		return thDiscussRelationGroupMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThDiscussRelationGroup record, ThDiscussRelationGroupExample example) {
		
		return thDiscussRelationGroupMapper.updateByExample(record, example);
	}

	@Override
	public List<ThDiscussRelationGroup> selectByExample(ThDiscussRelationGroupExample example) {
		
		return thDiscussRelationGroupMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThDiscussRelationGroupExample example) {
		
		return thDiscussRelationGroupMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThDiscussRelationGroupExample example) {
		
		return thDiscussRelationGroupMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thDiscussRelationGroup
	 * @return
	 */
	public int checkNameUnique(ThDiscussRelationGroup thDiscussRelationGroup){
		ThDiscussRelationGroupExample example=new ThDiscussRelationGroupExample();
		example.createCriteria().andDiscussGroupIdEqualTo(thDiscussRelationGroup.getDiscussGroupId());
		List<ThDiscussRelationGroup> list=thDiscussRelationGroupMapper.selectByExample(example);
		return list.size();
	}


}
