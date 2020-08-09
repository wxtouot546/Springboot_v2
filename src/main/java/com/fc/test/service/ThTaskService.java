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
import com.fc.test.mapper.auto.ThTaskMapper;
import com.fc.test.model.auto.ThTask;
import com.fc.test.model.auto.ThTaskExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThTaskService
 * @Title: ThTaskService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 13:18:53  
 **/
@Service
public class ThTaskService implements BaseService<ThTask, ThTaskExample>{
	@Autowired
	private ThTaskMapper thTaskMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThTask> list(Tablepar tablepar,String searchText){
	        ThTaskExample testExample=new ThTaskExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	testExample.createCriteria().andUrlLike("%"+searchText+"%");
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThTask> list= thTaskMapper.selectByExample(testExample);
	        PageInfo<ThTask> pageInfo = new PageInfo<ThTask>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThTaskExample example=new ThTaskExample();
			example.createCriteria().andIdIn(stringB);
			return thTaskMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThTask selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thTaskMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThTask record) {
		return thTaskMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThTask record) {
				
		record.setId(null);
		
				
		return thTaskMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThTask record, ThTaskExample example) {
		
		return thTaskMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThTask record, ThTaskExample example) {
		
		return thTaskMapper.updateByExample(record, example);
	}

	@Override
	public List<ThTask> selectByExample(ThTaskExample example) {
		
		return thTaskMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThTaskExample example) {
		
		return thTaskMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThTaskExample example) {
		
		return thTaskMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thTask
	 * @return
	 */
	public int checkNameUnique(ThTask thTask){
		ThTaskExample example=new ThTaskExample();
		example.createCriteria().andUrlEqualTo(thTask.getUrl());
		List<ThTask> list=thTaskMapper.selectByExample(example);
		return list.size();
	}


}
