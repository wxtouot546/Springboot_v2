package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThDiscussRelationGroup 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 19:33:22
 */
 @ApiModel(value="ThDiscussRelationGroup", description="")
public class ThDiscussRelationGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键id **/
	@ApiModelProperty(value = "主键id")
	private Integer id;
		
	/** 评论id **/
	@ApiModelProperty(value = "评论id")
	private Integer discussId;
		
	/** 评论组id **/
	@ApiModelProperty(value = "评论组id")
	private Integer discussGroupId;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 修改时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	
	private String searchText;
	
	private String discussName;
	
	private String discussGroupName;
	
		
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getDiscussName() {
		return discussName;
	}

	public void setDiscussName(String discussName) {
		this.discussName = discussName;
	}

	public String getDiscussGroupName() {
		return discussGroupName;
	}

	public void setDiscussGroupName(String discussGroupName) {
		this.discussGroupName = discussGroupName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	 
			
	public Integer getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Integer discussId) {
        this.discussId = discussId;
    }
	 
			
	public Integer getDiscussGroupId() {
        return discussGroupId;
    }

    public void setDiscussGroupId(Integer discussGroupId) {
        this.discussGroupId = discussGroupId;
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
	 
			
	public ThDiscussRelationGroup() {
        super();
    }
    
																											
	public ThDiscussRelationGroup(Integer id,Integer discussId,Integer discussGroupId,Date createTime,Date updateTime) {
	
		this.id = id;
		this.discussId = discussId;
		this.discussGroupId = discussGroupId;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}