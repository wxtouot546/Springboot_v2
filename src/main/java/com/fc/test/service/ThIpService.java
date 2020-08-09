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
import com.fc.test.mapper.auto.ThIpMapper;
import com.fc.test.model.auto.ThIp;
import com.fc.test.model.auto.ThIpExample;
import com.fc.test.model.custom.Tablepar;
import com.fc.test.util.SnowflakeIdWorker;
import com.fc.test.util.StringUtils;

/**
 *  ThIpService
 * @Title: ThIpService.java 
 * @Package com.fc.test.service 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-08 23:30:52  
 **/
@Service
public class ThIpService implements BaseService<ThIp, ThIpExample>{
	@Autowired
	private ThIpMapper thIpMapper;
	
      	   	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ThIp> list(Tablepar tablepar,String searchText){
	        ThIpExample testExample=new ThIpExample();
	        testExample.setOrderByClause("id ASC");
	        if(StrUtil.isNotEmpty(searchText)){
	        	testExample.createCriteria().andIpLike("%"+searchText+"%");
	        }
			if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        }
	        PageHelper.startPage(tablepar.getPageNum(), tablepar.getPageSize());
	        List<ThIp> list= thIpMapper.selectByExample(testExample);
	        PageInfo<ThIp> pageInfo = new PageInfo<ThIp>(list);
	        return  pageInfo;
	 }
	 
	public List<ThIp> selectAll(ThIp thIp){
		return thIpMapper.selectAll(thIp);
	}
	 
	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ThIpExample example=new ThIpExample();
			example.createCriteria().andIdIn(stringB);
			return thIpMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ThIp selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return thIpMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ThIp record) {
		return thIpMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ThIp record) {
				
		record.setId(null);
		
				
		return thIpMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ThIp record, ThIpExample example) {
		
		return thIpMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ThIp record, ThIpExample example) {
		
		return thIpMapper.updateByExample(record, example);
	}

	@Override
	public List<ThIp> selectByExample(ThIpExample example) {
		
		return thIpMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ThIpExample example) {
		
		return thIpMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ThIpExample example) {
		
		return thIpMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param thIp
	 * @return
	 */
	public int checkNameUnique(ThIp thIp){
		ThIpExample example=new ThIpExample();
		example.createCriteria().andIpEqualTo(thIp.getIp());
		List<ThIp> list=thIpMapper.selectByExample(example);
		return list.size();
	}


}
