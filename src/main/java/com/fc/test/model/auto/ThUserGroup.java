package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThUserGroup 
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2020-08-07 21:42:31
 */
 @ApiModel(value="ThUserGroup", description="")
public class ThUserGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 用户组ID **/
	@ApiModelProperty(value = "用户组ID")
	private Integer id;
		
	/** 用户组名字 **/
	@ApiModelProperty(value = "用户组名字")
	private String userGroupName;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 更新时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
		
		
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	 
			
	public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
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
	 
			
	public ThUserGroup() {
        super();
    }
    
																						
	public ThUserGroup(Integer id,String userGroupName,Date createTime,Date updateTime) {
	
		this.id = id;
		this.userGroupName = userGroupName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}