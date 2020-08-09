package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThUserGroup;
import com.fc.test.model.auto.ThUserGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThUserGroupMapper
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2020-08-07 21:42:31
 */
public interface ThUserGroupMapper {
      	   	      	      	      	      
    long countByExample(ThUserGroupExample example);

    int deleteByExample(ThUserGroupExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThUserGroup record);

    int insertSelective(ThUserGroup record);

    List<ThUserGroup> selectByExample(ThUserGroupExample example);
    
    List<ThUserGroup> selectAll(ThUserGroup records);
		
    ThUserGroup selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ThUserGroup record, @Param("example") ThUserGroupExample example);

    int updateByExample(@Param("record") ThUserGroup record, @Param("example") ThUserGroupExample example); 
		
    int updateByPrimaryKeySelective(ThUserGroup record);

    int updateByPrimaryKey(ThUserGroup record);
  	  	
}