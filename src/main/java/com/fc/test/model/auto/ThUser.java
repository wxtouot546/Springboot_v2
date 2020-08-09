package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.lang.Character;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThUser 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-07 20:38:44
 */
 @ApiModel(value="ThUser", description="")
public class ThUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键 **/
	@ApiModelProperty(value = "主键")
	private Integer id;
		
	/** 用户id **/
	@ApiModelProperty(value = "用户id")
	private String userId;
	
	//用户组名字
	private String userGroupName;
	
	// ip地址
	private String ipName;
		
	/** 用户ip **/
	@ApiModelProperty(value = "用户ip")
	private String ipId;
		
	/** 用户密码（明文） **/
	@ApiModelProperty(value = "用户密码（明文）")
	private String password;
		
	/** 分数 **/
	@ApiModelProperty(value = "分数")
	private Integer fraction;
		
	/** 等级 **/
	@ApiModelProperty(value = "等级")
	private Integer grade;
		
	/** 状态（0正常，1被封号） **/
	@ApiModelProperty(value = "状态（0正常，1被封号）")
	private Character isdel;
		
	/** 创建时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "创建时间")
	private Date creatTime;
		
	/** 更新时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	
	public String getIpName() {
		return ipName;
	}

	public void setIpName(String ipName) {
		this.ipName = ipName;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
	 
			
	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
	 
			
	public String getIpId() {
        return ipId;
    }

    public void setIpId(String ipId) {
        this.ipId = ipId;
    }
	 
			
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	 
			
	public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }
	 
			
	public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
	 
			
	public Character getIsdel() {
        return isdel;
    }

    public void setIsdel(Character isdel) {
        this.isdel = isdel;
    }
	 
			
	public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
	 
			
	public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	 
			
	public ThUser() {
        super();
    }
    
																																															
	public ThUser(Integer id,String userId,String ipId,String password,Integer fraction,Integer grade,Character isdel,Date creatTime,Date updateTime) {
	
		this.id = id;
		this.userId = userId;
		this.ipId = ipId;
		this.password = password;
		this.fraction = fraction;
		this.grade = grade;
		this.isdel = isdel;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
		
	}
	
}