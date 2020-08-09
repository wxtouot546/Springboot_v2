package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThUser;
import com.fc.test.model.auto.ThUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 *  ThUserMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-07 20:38:44
 */
public interface ThUserMapper {
      	   	      	      	      	      	      	      	      	      	      
    long countByExample(ThUserExample example);

    int deleteByExample(ThUserExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThUser record);

    int insertSelective(ThUser record);

    List<ThUser> selectByExample(ThUserExample example);
    
    List<ThUser> selectByu(Map<String,Object>map);
    
    List<ThUser> selectAllbygrop(Integer id);
    
    List<ThUser> selectAll(ThUser record);
    
    List<ThUser> selectAllbyName(ThUser record);
		
    ThUser selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ThUser record, @Param("example") ThUserExample example);

    int updateByExample(@Param("record") ThUser record, @Param("example") ThUserExample example); 
		
    int updateByPrimaryKeySelective(ThUser record);

    int updateByPrimaryKey(ThUser record);
  	  	
}