package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThUserRelationGroup;
import com.fc.test.model.auto.ThUserRelationGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThUserRelationGroupMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-07 22:16:02
 */
public interface ThUserRelationGroupMapper {
      	   	      	      	      	      	      
    long countByExample(ThUserRelationGroupExample example);

    int deleteByExample(ThUserRelationGroupExample example);
		
    int deleteByPrimaryKey(Integer id);
    int deleteByPrimaryUser(Integer id);
    
    ThUserRelationGroup selectByPrimaryuser(ThUserRelationGroup thUserRelationGroup);
    
    ThUserRelationGroup selectByPrimaryuserALL(ThUserRelationGroup thUserRelationGroup);
    
    ThUserRelationGroup selectKeyType(ThUserRelationGroup thUserRelationGroup);
		
    int insert(ThUserRelationGroup record);

    int insertSelective(ThUserRelationGroup record);

    List<ThUserRelationGroup> selectByExample(ThUserRelationGroupExample example);
		
    ThUserRelationGroup selectByPrimaryKey(Integer id);
    
    List<ThUserRelationGroup> selectByPrimaryuserid(Integer id);
		
    int updateByExampleSelective(@Param("record") ThUserRelationGroup record, @Param("example") ThUserRelationGroupExample example);

    int updateByExample(@Param("record") ThUserRelationGroup record, @Param("example") ThUserRelationGroupExample example); 
		
    int updateByPrimaryKeySelective(ThUserRelationGroup record);

    int updateByPrimaryKey(ThUserRelationGroup record);
  	  	
}