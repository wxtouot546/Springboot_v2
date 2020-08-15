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
import com.fc.test.mapper.auto.ThTaskSplitMapper;
import com.fc.test.model.auto.ThTaskSplit;
import com.fc.test.model.auto.ThTaskSplitExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThTaskSplitService
 * @Title: ThTaskSplitService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-13 19:09:18  
 **/
@Service
public class ThTaskSplitService implements BaseService<ThTaskSplit, ThTaskSplitExample>{
	@Autowired
	private ThTaskSplitMapper thTaskSplitMapper;
	
      	   	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThTaskSplit> list(Tablepar tablepar,String searchText){
	        ThTaskSplitExample testExample=new ThTaskSplitExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
				/* testExample.createCriteria().andTaskIdLike("%"+searchText+"%"); */
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThTaskSplit> list= thTaskSplitMapper.selectByExample(testExample);
	        PageInfo<ThTaskSplit> pageInfo = new PageInfo<ThTaskSplit>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThTaskSplitExample example=new ThTaskSplitExample();
			example.createCriteria().andIdIn(stringB);
			return thTaskSplitMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThTaskSplit selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thTaskSplitMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThTaskSplit record) {
		return thTaskSplitMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThTaskSplit record) {
				
		record.setId(null);
		
				
		return thTaskSplitMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThTaskSplit record, ThTaskSplitExample example) {
		
		return thTaskSplitMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThTaskSplit record, ThTaskSplitExample example) {
		
		return thTaskSplitMapper.updateByExample(record, example);
	}

	@Override
	public List<ThTaskSplit> selectByExample(ThTaskSplitExample example) {
		
		return thTaskSplitMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThTaskSplitExample example) {
		
		return thTaskSplitMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThTaskSplitExample example) {
		
		return thTaskSplitMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thTaskSplit
	 * @return
	 */
	public int checkNameUnique(ThTaskSplit thTaskSplit){
		ThTaskSplitExample example=new ThTaskSplitExample();
		example.createCriteria().andTaskIdEqualTo(thTaskSplit.getTaskId());
		List<ThTaskSplit> list=thTaskSplitMapper.selectByExample(example);
		return list.size();
	}


}
