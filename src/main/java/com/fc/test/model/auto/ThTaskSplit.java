package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThTaskSplit 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-13 19:09:18
 */
 @ApiModel(value="ThTaskSplit", description="")
public class ThTaskSplit implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键id **/
	@ApiModelProperty(value = "主键id")
	private Integer id;
		
	/** 帖子id **/
	@ApiModelProperty(value = "帖子id")
	private Integer taskId;
		
	/** 用户id **/
	@ApiModelProperty(value = "用户id")
	private Integer userId;
		
	/** 评论id **/
	@ApiModelProperty(value = "评论id")
	private Integer discussId;
		
	/** (0未执行，1已执行) **/
	@ApiModelProperty(value = "(0未执行，1已执行)")
	private Integer type;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 更新时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
		
	private String userValue;
	
	public String getUserValue() {
		return userValue;
	}

	public void setUserValue(String userValue) {
		this.userValue = userValue;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	 
			
	public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
	 
			
	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
	 
			
	public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }
	 
			
	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
	 
			
	public ThTaskSplit() {
        super();
    }
    
																																					
	public ThTaskSplit(Integer id,Integer taskId,Integer userId,Integer discussId,Integer type,Date createTime,Date updateTime) {
	
		this.id = id;
		this.taskId = taskId;
		this.userId = userId;
		this.discussId = discussId;
		this.type = type;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}