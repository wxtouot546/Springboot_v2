package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThDiscussGroup;
import com.fc.test.model.auto.ThDiscussGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThDiscussGroupMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:32:21
 */
public interface ThDiscussGroupMapper {
      	   	      	      	      	      
    long countByExample(ThDiscussGroupExample example);

    int deleteByExample(ThDiscussGroupExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThDiscussGroup record);

    int insertSelective(ThDiscussGroup record);

    List<ThDiscussGroup> selectByExample(ThDiscussGroupExample example);
    
    List<ThDiscussGroup> selectByExample1(ThDiscussGroup thDiscussGroup);
    
    List<ThDiscussGroup> selectAll(ThDiscussGroup record);
		
    ThDiscussGroup selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ThDiscussGroup record, @Param("example") ThDiscussGroupExample example);

    int updateByExample(@Param("record") ThDiscussGroup record, @Param("example") ThDiscussGroupExample example); 
		
    int updateByPrimaryKeySelective(ThDiscussGroup record);

    int updateByPrimaryKey(ThDiscussGroup record);
  	  	
}