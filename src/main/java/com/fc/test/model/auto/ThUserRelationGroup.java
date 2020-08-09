package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThUserRelationGroup 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-07 22:16:02
 */
 @ApiModel(value="ThUserRelationGroup", description="")
public class ThUserRelationGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键ID **/
	@ApiModelProperty(value = "主键ID")
	private Integer id;
		
	/** 用户id **/
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	
	private String userName;
		
	/** 用户组ID **/
	@ApiModelProperty(value = "用户组ID")
	private Integer gorupId;
	
	private String groupName;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 更新时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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
	 
			
	public Integer getGorupId() {
        return gorupId;
    }

    public void setGorupId(Integer gorupId) {
        this.gorupId = gorupId;
    }
	 
			
	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
	 
			
	public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	 
			
	public ThUserRelationGroup() {
        super();
    }
    
																											
	public ThUserRelationGroup(Integer id,Integer userId,Integer gorupId,Date createTime,Date updateTime) {
	
		this.id = id;
		this.userId = userId;
		this.gorupId = gorupId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}