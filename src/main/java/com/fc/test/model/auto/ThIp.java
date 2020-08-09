package com.fc.test.model.auto;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.lang.Character;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.Integer;

/**
 *  ThIp 
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-08 23:30:52
 */
 @ApiModel(value="ThIp", description="")
public class ThIp implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	/** 主键id **/
	@ApiModelProperty(value = "主键id")
	private Integer id;
		
	/** ip **/
	@ApiModelProperty(value = "ip")
	private String ip;
		
	/** 类型（0静态ip，1动态ip） **/
	@ApiModelProperty(value = "类型（0静态ip，1动态ip）")
	private Character type;
		
	/** 动态ip来源（静态ip没有） **/
	@ApiModelProperty(value = "动态ip来源（静态ip没有）")
	private String dateSource;
		
	/** (0正常，1停用) **/
	@ApiModelProperty(value = "(0正常，1停用)")
	private Character status;
		
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
	 
			
	public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
	 
			
	public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }
	 
			
	public String getDateSource() {
        return dateSource;
    }

    public void setDateSource(String dateSource) {
        this.dateSource = dateSource;
    }
	 
			
	public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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
	 
			
	public ThIp() {
        super();
    }
    
																																					
	public ThIp(Integer id,String ip,Character type,String dateSource,Character status,Date createTime,Date updateTime) {
	
		this.id = id;
		this.ip = ip;
		this.type = type;
		this.dateSource = dateSource;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
		
	}
	
}