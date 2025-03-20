package com.entity.model;

import com.entity.KuaidiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 快递
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-16
 */
public class KuaidiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 快递单号
     */
    private String kuaidiNumber;


    /**
     * 运送物品
     */
    private String kuaidiName;


    /**
     * 快递金额
     */
    private Integer kuaidiMoney;


    /**
     * 快递详细内容
     */
    private String kuaidiContent;


    /**
     * 快递最新物流状态
     */
    private String kuaidiThisValue;


    /**
     * 是否签收
     */
    private Integer kuaidiTypes;


    /**
     * 快递时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：快递单号
	 */
    public String getKuaidiNumber() {
        return kuaidiNumber;
    }


    /**
	 * 设置：快递单号
	 */
    public void setKuaidiNumber(String kuaidiNumber) {
        this.kuaidiNumber = kuaidiNumber;
    }
    /**
	 * 获取：运送物品
	 */
    public String getKuaidiName() {
        return kuaidiName;
    }


    /**
	 * 设置：运送物品
	 */
    public void setKuaidiName(String kuaidiName) {
        this.kuaidiName = kuaidiName;
    }
    /**
	 * 获取：快递金额
	 */
    public Integer getKuaidiMoney() {
        return kuaidiMoney;
    }


    /**
	 * 设置：快递金额
	 */
    public void setKuaidiMoney(Integer kuaidiMoney) {
        this.kuaidiMoney = kuaidiMoney;
    }
    /**
	 * 获取：快递详细内容
	 */
    public String getKuaidiContent() {
        return kuaidiContent;
    }


    /**
	 * 设置：快递详细内容
	 */
    public void setKuaidiContent(String kuaidiContent) {
        this.kuaidiContent = kuaidiContent;
    }
    /**
	 * 获取：快递最新物流状态
	 */
    public String getKuaidiThisValue() {
        return kuaidiThisValue;
    }


    /**
	 * 设置：快递最新物流状态
	 */
    public void setKuaidiThisValue(String kuaidiThisValue) {
        this.kuaidiThisValue = kuaidiThisValue;
    }
    /**
	 * 获取：是否签收
	 */
    public Integer getKuaidiTypes() {
        return kuaidiTypes;
    }


    /**
	 * 设置：是否签收
	 */
    public void setKuaidiTypes(Integer kuaidiTypes) {
        this.kuaidiTypes = kuaidiTypes;
    }
    /**
	 * 获取：快递时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：快递时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
