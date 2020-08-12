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
import com.fc.test.mapper.auto.ThDiscussGroupMapper;
import com.fc.test.model.auto.ThDiscussGroup;
import com.fc.test.model.auto.ThDiscussGroupExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThDiscussGroupService
 * @Title: ThDiscussGroupService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:32:21  
 **/
@Service
public class ThDiscussGroupService implements BaseService<ThDiscussGroup, ThDiscussGroupExample>{
	@Autowired
	private ThDiscussGroupMapper thDiscussGroupMapper;
	
      	   	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThDiscussGroup> list(Tablepar tablepar,String searchText){
	        ThDiscussGroupExample testExample=new ThDiscussGroupExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	testExample.createCriteria().andDiscussGroupNameLike("%"+searchText+"%");
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThDiscussGroup> list= thDiscussGroupMapper.selectByExample(testExample);
	        PageInfo<ThDiscussGroup> pageInfo = new PageInfo<ThDiscussGroup>(list);
	        return  pageInfo;
	 }
	 
	public List <ThDiscussGroup> listAll(ThDiscussGroup thDiscussGroup){
	       List<ThDiscussGroup> list= thDiscussGroupMapper.selectByExample1(thDiscussGroup);
	       return  list;
	}
	public ThDiscussGroup selectByPrimaryName(ThDiscussGroup record) {
		ThDiscussGroup rhDiscussGroup= thDiscussGroupMapper.selectByPrimaryName(record);
		return  rhDiscussGroup;
	}
	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThDiscussGroupExample example=new ThDiscussGroupExample();
			example.createCriteria().andIdIn(stringB);
			return thDiscussGroupMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThDiscussGroup selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thDiscussGroupMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThDiscussGroup record) {
		return thDiscussGroupMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThDiscussGroup record) {
				
		record.setId(null);
		
				
		return thDiscussGroupMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThDiscussGroup record, ThDiscussGroupExample example) {
		
		return thDiscussGroupMapper.updateByExampleSelective(record, example);
	}

	public List<ThDiscussGroup> selectAll(ThDiscussGroup record){
		return thDiscussGroupMapper.selectAll(record);
	}
	
	@Override
	public int updateByExample(ThDiscussGroup record, ThDiscussGroupExample example) {
		
		return thDiscussGroupMapper.updateByExample(record, example);
	}

	@Override
	public List<ThDiscussGroup> selectByExample(ThDiscussGroupExample example) {
		
		return thDiscussGroupMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThDiscussGroupExample example) {
		
		return thDiscussGroupMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThDiscussGroupExample example) {
		
		return thDiscussGroupMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thDiscussGroup
	 * @return
	 */
	public int checkNameUnique(ThDiscussGroup thDiscussGroup){
		ThDiscussGroupExample example=new ThDiscussGroupExample();
		example.createCriteria().andDiscussGroupNameEqualTo(thDiscussGroup.getDiscussGroupName());
		List<ThDiscussGroup> list=thDiscussGroupMapper.selectByExample(example);
		return list.size();
	}


}
