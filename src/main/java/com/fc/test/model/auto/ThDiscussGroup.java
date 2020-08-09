package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThDiscussGroup 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:32:21
 */
 @ApiModel(value="ThDiscussGroup", description="")
public class ThDiscussGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键id **/
	@ApiModelProperty(value = "主键id")
	private Integer id;
		
	/** 评论组名字 **/
	@ApiModelProperty(value = "评论组名字")
	private String discussGroupName;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 修改时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
		
		
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	 
			
	public String getDiscussGroupName() {
        return discussGroupName;
    }

    public void setDiscussGroupName(String discussGroupName) {
        this.discussGroupName = discussGroupName;
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
	 
			
	public ThDiscussGroup() {
        super();
    }
    
																						
	public ThDiscussGroup(Integer id,String discussGroupName,Date createTime,Date updateTime) {
	
		this.id = id;
		this.discussGroupName = discussGroupName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}