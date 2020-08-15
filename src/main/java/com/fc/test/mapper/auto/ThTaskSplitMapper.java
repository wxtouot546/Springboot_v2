package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThTask;
import com.fc.test.model.auto.ThTaskSplit;
import com.fc.test.model.auto.ThTaskSplitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThTaskSplitMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-13 19:09:18
 */
public interface ThTaskSplitMapper {
      	   	      	      	      	      	      	      	      
    long countByExample(ThTaskSplitExample example);

    int deleteByExample(ThTaskSplitExample example);
    
    List<ThTaskSplit> selectAllius(@Param("taskId") Integer taskId);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThTaskSplit record);
    int insertList(@Param("list") List<ThTaskSplit> list);
    
    int insertSelective(ThTaskSplit record);

    List<ThTaskSplit> selectByExample(ThTaskSplitExample example);
		
    ThTaskSplit selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ThTaskSplit record, @Param("example") ThTaskSplitExample example);

    int updateByExample(@Param("record") ThTaskSplit record, @Param("example") ThTaskSplitExample example); 
		
    int updateByPrimaryKeySelective(ThTaskSplit record);

    int updateByPrimaryKey(ThTaskSplit record);
  	  	
}