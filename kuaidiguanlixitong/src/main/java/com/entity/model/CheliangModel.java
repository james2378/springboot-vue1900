package com.entity.model;

import com.entity.CheliangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-16
 */
public class CheliangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车辆名字
     */
    private String cheliangName;


    /**
     * 车辆类型
     */
    private Integer cheliangLeixingTypes;


    /**
     * 车辆编号
     */
    private String cheliangNumber;


    /**
     * 车辆详情
     */
    private String cheliangContent;


    /**
     * 是否使用
     */
    private Integer cheliangTypes;


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
	 * 获取：车辆名字
	 */
    public String getCheliangName() {
        return cheliangName;
    }


    /**
	 * 设置：车辆名字
	 */
    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
    }
    /**
	 * 获取：车辆类型
	 */
    public Integer getCheliangLeixingTypes() {
        return cheliangLeixingTypes;
    }


    /**
	 * 设置：车辆类型
	 */
    public void setCheliangLeixingTypes(Integer cheliangLeixingTypes) {
        this.cheliangLeixingTypes = cheliangLeixingTypes;
    }
    /**
	 * 获取：车辆编号
	 */
    public String getCheliangNumber() {
        return cheliangNumber;
    }


    /**
	 * 设置：车辆编号
	 */
    public void setCheliangNumber(String cheliangNumber) {
        this.cheliangNumber = cheliangNumber;
    }
    /**
	 * 获取：车辆详情
	 */
    public String getCheliangContent() {
        return cheliangContent;
    }


    /**
	 * 设置：车辆详情
	 */
    public void setCheliangContent(String cheliangContent) {
        this.cheliangContent = cheliangContent;
    }
    /**
	 * 获取：是否使用
	 */
    public Integer getCheliangTypes() {
        return cheliangTypes;
    }


    /**
	 * 设置：是否使用
	 */
    public void setCheliangTypes(Integer cheliangTypes) {
        this.cheliangTypes = cheliangTypes;
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
