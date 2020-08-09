package com.fc.test.mapper.auto;

import com.fc.test.model.auto.ThIp;
import com.fc.test.model.auto.ThIpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ThIpMapper
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-08 23:30:52
 */
public interface ThIpMapper {
      	   	      	      	      	      	      	      	      
    long countByExample(ThIpExample example);

    int deleteByExample(ThIpExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ThIp record);

    int insertSelective(ThIp record);

    List<ThIp> selectByExample(ThIpExample example);
    
    List<ThIp> selectAll(ThIp thIp);
		
    ThIp selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ThIp record, @Param("example") ThIpExample example);

    int updateByExample(@Param("record") ThIp record, @Param("example") ThIpExample example); 
		
    int updateByPrimaryKeySelective(ThIp record);

    int updateByPrimaryKey(ThIp record);
  	  	
}