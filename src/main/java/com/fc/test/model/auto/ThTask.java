package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.lang.Character;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThTask 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 13:18:53
 */
 @ApiModel(value="ThTask", description="")
public class ThTask implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键id **/
	@ApiModelProperty(value = "主键id")
	private Integer id;
		
	/** 帖子url/板块id **/
	@ApiModelProperty(value = "帖子url/板块id")
	private String url;
		
	/** 类型（1顶贴，2刷分,3刷帖） **/
	@ApiModelProperty(value = "类型（1顶贴，2刷分,3刷帖）")
	private Character type;
		
	/** 回复数量/帖子抓取数量/浏览量 **/
	@ApiModelProperty(value = "回复数量/帖子抓取数量/浏览量")
	private Integer number;
		
	/** 已经完成数量 **/
	@ApiModelProperty(value = "已经完成数量")
	private Integer oldNumber;
	
	/** 用户id多个（逗号分割） **/
	@ApiModelProperty(value = "用户id多个（逗号分割）")
	private String userIds;
		
	/** 评论id（多个逗号分割） **/
	@ApiModelProperty(value = "评论id（多个逗号分割）")
	private String duscussIds;
		
	/** 用户组id **/
	@ApiModelProperty(value = "用户组id")
	private Integer userGroupId;
	
	private String userNames;
	
	private String duscussNames;
	
	private String groupName;
	
	private String discussGroupName;
	
	/** 评论组id **/
	@ApiModelProperty(value = "评论组id")
	private Integer discussGroupId;
		
	/** 回复间隔开始（秒） **/
	@ApiModelProperty(value = "回复间隔开始（秒）")
	private Integer start;
		
	/** 回复间隔结束（秒） **/
	@ApiModelProperty(value = "回复间隔结束（秒）")
	private Integer end;
		
	/** 状态（0开始，1暂停，2结束） **/
	@ApiModelProperty(value = "状态（0开始，1暂停，2结束）")
	private Character isdel;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
		
	/** 更新时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
		
	
	public String getDuscussNames() {
		return duscussNames;
	}

	public void setDuscussNames(String duscussNames) {
		this.duscussNames = duscussNames;
	}

	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public String getDiscussGroupName() {
		return discussGroupName;
	}

	public void setDiscussGroupName(String discussGroupName) {
		this.discussGroupName = discussGroupName;
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
	 
			
	public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
	 
			
	public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }
	 
			
	public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
	 
			
	public Integer getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(Integer oldNumber) {
        this.oldNumber = oldNumber;
    }
	 
			
	public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }
	 
			
	public String getDuscussIds() {
        return duscussIds;
    }

    public void setDuscussIds(String duscussIds) {
        this.duscussIds = duscussIds;
    }
	 
			
	public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }
	 
			
	public Integer getDiscussGroupId() {
        return discussGroupId;
    }

    public void setDiscussGroupId(Integer discussGroupId) {
        this.discussGroupId = discussGroupId;
    }
	 
			
	public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
	 
			
	public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
	 
			
	public Character getIsdel() {
        return isdel;
    }

    public void setIsdel(Character isdel) {
        this.isdel = isdel;
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
	 
			
	public ThTask() {
        super();
    }
    
																																																																								
	public ThTask(Integer id,String url,Character type,Integer number,Integer oldNumber,String userIds,String duscussIds,Integer userGroupId,Integer discussGroupId,Integer start,Integer end,Character isdel,Date createTime,Date updateTime) {
	
		this.id = id;
		this.url = url;
		this.type = type;
		this.number = number;
		this.oldNumber = oldNumber;
		this.userIds = userIds;
		this.duscussIds = duscussIds;
		this.userGroupId = userGroupId;
		this.discussGroupId = discussGroupId;
		this.start = start;
		this.end = end;
		this.isdel = isdel;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}