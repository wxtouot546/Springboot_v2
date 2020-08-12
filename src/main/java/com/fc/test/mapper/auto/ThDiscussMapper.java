package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThDiscuss;
import com.fc.test.model.auto.ThDiscussExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThDiscussMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:29:12
 */
public interface ThDiscussMapper {
      	   	      	      	      	      
    long countByExample(ThDiscussExample example);

    int deleteByExample(ThDiscussExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThDiscuss record);

    int insertSelective(ThDiscuss record);

    List<ThDiscuss> selectByExample(ThDiscussExample example);
    
    List<ThDiscuss> selectByALL(ThDiscuss record);
		
    ThDiscuss selectByPrimaryKey(Integer id);
    
    ThDiscuss selectByPrimaryName(ThDiscuss record);
		
    int updateByExampleSelective(@Param("record") ThDiscuss record, @Param("example") ThDiscussExample example);

    int updateByExample(@Param("record") ThDiscuss record, @Param("example") ThDiscussExample example); 
		
    int updateByPrimaryKeySelective(ThDiscuss record);

    int updateByPrimaryKey(ThDiscuss record);
  	  	
}