package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThHistory 
 * @author sssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-13 21:42:26
 */
 @ApiModel(value="ThHistory", description="")
public class ThHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键id **/
	@ApiModelProperty(value = "主键id")
	private Integer id;
		
	/** 用户id **/
	@ApiModelProperty(value = "用户id")
	private Integer userId;
		
	/** 操作内容 **/
	@ApiModelProperty(value = "操作内容")
	private String value;
		
	/** 操作时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "操作时间")
	private Date createTime;
	
	private String userName;
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	 
			
	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
	 
			
	public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
	 
			
	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	 
			
	public ThHistory() {
        super();
    }
    
																						
	public ThHistory(Integer id,Integer userId,String value,Date createTime) {
	
		this.id = id;
		this.userId = userId;
		this.value = value;
		this.createTime = createTime;
		
	}
	
}