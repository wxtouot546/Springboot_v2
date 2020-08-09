package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThDiscuss 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:29:12
 */
 @ApiModel(value="ThDiscuss", description="")
public class ThDiscuss implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键id **/
	@ApiModelProperty(value = "主键id")
	private Integer id;
		
	/** 评论 **/
	@ApiModelProperty(value = "评论")
	private String discussName;
		
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
	 
			
	public String getDiscussName() {
        return discussName;
    }

    public void setDiscussName(String discussName) {
        this.discussName = discussName;
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
	 
			
	public ThDiscuss() {
        super();
    }
    
																						
	public ThDiscuss(Integer id,String discussName,Date createTime,Date updateTime) {
	
		this.id = id;
		this.discussName = discussName;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}