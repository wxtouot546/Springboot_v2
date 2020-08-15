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
import com.fc.test.mapper.auto.ThHistoryMapper;
import com.fc.test.model.auto.ThHistory;
import com.fc.test.model.auto.ThHistoryExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThHistoryService
 * @Title: ThHistoryService.java 
 * @Package com.fc.test.service 
 * @author sssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-13 21:42:26  
 **/
@Service
public class ThHistoryService implements BaseService<ThHistory, ThHistoryExample>{
	@Autowired
	private ThHistoryMapper thHistoryMapper;
	
      	   	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThHistory> list(Tablepar tablepar,String searchText){
	        ThHistoryExample testExample=new ThHistoryExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
				/* testExample.createCriteria().andUserIdLike("%"+searchText+"%"); */
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThHistory> list= thHistoryMapper.selectByExample(testExample);
	        PageInfo<ThHistory> pageInfo = new PageInfo<ThHistory>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThHistoryExample example=new ThHistoryExample();
			example.createCriteria().andIdIn(stringB);
			return thHistoryMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThHistory selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thHistoryMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThHistory record) {
		return thHistoryMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThHistory record) {
				
		record.setId(null);
		
				
		return thHistoryMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThHistory record, ThHistoryExample example) {
		
		return thHistoryMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThHistory record, ThHistoryExample example) {
		
		return thHistoryMapper.updateByExample(record, example);
	}

	@Override
	public List<ThHistory> selectByExample(ThHistoryExample example) {
		
		return thHistoryMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThHistoryExample example) {
		
		return thHistoryMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThHistoryExample example) {
		
		return thHistoryMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thHistory
	 * @return
	 */
	public int checkNameUnique(ThHistory thHistory){
		ThHistoryExample example=new ThHistoryExample();
		example.createCriteria().andUserIdEqualTo(thHistory.getUserId());
		List<ThHistory> list=thHistoryMapper.selectByExample(example);
		return list.size();
	}


}
