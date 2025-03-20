package com.entity.model;

import com.entity.DiaoduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆调度
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-16
 */
public class DiaoduModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆
     */
    private Integer cheliangId;


    /**
     * 始发站
     */
    private String diaoduStart;


    /**
     * 目的地
     */
    private String diaoduEnd;


    /**
     * 是否使用
     */
    private Integer diaoduTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 设置：车辆
	 */
    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 获取：始发站
	 */
    public String getDiaoduStart() {
        return diaoduStart;
    }


    /**
	 * 设置：始发站
	 */
    public void setDiaoduStart(String diaoduStart) {
        this.diaoduStart = diaoduStart;
    }
    /**
	 * 获取：目的地
	 */
    public String getDiaoduEnd() {
        return diaoduEnd;
    }


    /**
	 * 设置：目的地
	 */
    public void setDiaoduEnd(String diaoduEnd) {
        this.diaoduEnd = diaoduEnd;
    }
    /**
	 * 获取：是否使用
	 */
    public Integer getDiaoduTypes() {
        return diaoduTypes;
    }


    /**
	 * 设置：是否使用
	 */
    public void setDiaoduTypes(Integer diaoduTypes) {
        this.diaoduTypes = diaoduTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
