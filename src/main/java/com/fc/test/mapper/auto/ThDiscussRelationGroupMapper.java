package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThDiscussRelationGroup;
import com.fc.test.model.auto.ThDiscussRelationGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThDiscussRelationGroupMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:33:22
 */
public interface ThDiscussRelationGroupMapper {
      	   	      	      	      	      	      
    long countByExample(ThDiscussRelationGroupExample example);

    int deleteByExample(ThDiscussRelationGroupExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThDiscussRelationGroup record);

    int insertSelective(ThDiscussRelationGroup record);

    List<ThDiscussRelationGroup> selectByExample(ThDiscussRelationGroupExample example);
    List<ThDiscussRelationGroup> selectByExample1(ThDiscussRelationGroup record);
		
    ThDiscussRelationGroup selectByPrimaryKey(Integer id);
    
    ThDiscussRelationGroup selectByPrimaryName(ThDiscussRelationGroup record);
    ThDiscussRelationGroup selectByPrimaryName1(ThDiscussRelationGroup record);
		
    int updateByExampleSelective(@Param("record") ThDiscussRelationGroup record, @Param("example") ThDiscussRelationGroupExample example);

    int updateByExample(@Param("record") ThDiscussRelationGroup record, @Param("example") ThDiscussRelationGroupExample example); 
		
    int updateByPrimaryKeySelective(ThDiscussRelationGroup record);

    int updateByPrimaryKey(ThDiscussRelationGroup record);
  	  	
}