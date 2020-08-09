package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThTask;
import com.fc.test.model.auto.ThTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThTaskMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 13:18:53
 */
public interface ThTaskMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(ThTaskExample example);

    int deleteByExample(ThTaskExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThTask record);

    int insertSelective(ThTask record);

    List<ThTask> selectByExample(ThTaskExample example);
		
    ThTask selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ThTask record, @Param("example") ThTaskExample example);

    int updateByExample(@Param("record") ThTask record, @Param("example") ThTaskExample example); 
		
    int updateByPrimaryKeySelective(ThTask record);

    int updateByPrimaryKey(ThTask record);
  	  	
}