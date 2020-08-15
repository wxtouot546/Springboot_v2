package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThHistory;
import com.fc.test.model.auto.ThHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThHistoryMapper
 * @author sssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-13 21:42:26
 */
public interface ThHistoryMapper {
      	   	      	      	      	      
    long countByExample(ThHistoryExample example);

    int deleteByExample(ThHistoryExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThHistory record);

    int insertSelective(ThHistory record);

    List<ThHistory> selectByExample(ThHistoryExample example);
		
    ThHistory selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ThHistory record, @Param("example") ThHistoryExample example);

    int updateByExample(@Param("record") ThHistory record, @Param("example") ThHistoryExample example); 
		
    int updateByPrimaryKeySelective(ThHistory record);

    int updateByPrimaryKey(ThHistory record);
  	  	
}