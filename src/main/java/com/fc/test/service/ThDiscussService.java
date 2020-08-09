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
import com.fc.test.mapper.auto.ThDiscussMapper;
import com.fc.test.model.auto.ThDiscuss;
import com.fc.test.model.auto.ThDiscussExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThDiscussService
 * @Title: ThDiscussService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:29:12  
 **/
@Service
public class ThDiscussService implements BaseService<ThDiscuss, ThDiscussExample>{
	@Autowired
	private ThDiscussMapper thDiscussMapper;
	
      	   	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThDiscuss> list(Tablepar tablepar,String searchText){
	        ThDiscussExample testExample=new ThDiscussExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	testExample.createCriteria().andDiscussNameLike("%"+searchText+"%");
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThDiscuss> list= thDiscussMapper.selectByExample(testExample);
	        PageInfo<ThDiscuss> pageInfo = new PageInfo<ThDiscuss>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThDiscussExample example=new ThDiscussExample();
			example.createCriteria().andIdIn(stringB);
			return thDiscussMapper.deleteByExample(example);
			
				
	}
	
	public List<ThDiscuss> selectByALL(ThDiscuss record){
		return thDiscussMapper.selectByALL(record);
	}
	
	@Override
	public ThDiscuss selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thDiscussMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThDiscuss record) {
		return thDiscussMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThDiscuss record) {
				
		record.setId(null);
		
				
		return thDiscussMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThDiscuss record, ThDiscussExample example) {
		
		return thDiscussMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThDiscuss record, ThDiscussExample example) {
		
		return thDiscussMapper.updateByExample(record, example);
	}

	@Override
	public List<ThDiscuss> selectByExample(ThDiscussExample example) {
		
		return thDiscussMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThDiscussExample example) {
		
		return thDiscussMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThDiscussExample example) {
		
		return thDiscussMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thDiscuss
	 * @return
	 */
	public int checkNameUnique(ThDiscuss thDiscuss){
		ThDiscussExample example=new ThDiscussExample();
		example.createCriteria().andDiscussNameEqualTo(thDiscuss.getDiscussName());
		List<ThDiscuss> list=thDiscussMapper.selectByExample(example);
		return list.size();
	}


}
