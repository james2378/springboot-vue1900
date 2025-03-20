package com.entity.vo;

import com.entity.KuaidiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 快递
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("kuaidi")
public class KuaidiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 快递单号
     */

    @TableField(value = "kuaidi_number")
    private String kuaidiNumber;


    /**
     * 运送物品
     */

    @TableField(value = "kuaidi_name")
    private String kuaidiName;


    /**
     * 快递金额
     */

    @TableField(value = "kuaidi_money")
    private Integer kuaidiMoney;


    /**
     * 快递详细内容
     */

    @TableField(value = "kuaidi_content")
    private String kuaidiContent;


    /**
     * 快递最新物流状态
     */

    @TableField(value = "kuaidi_this_value")
    private String kuaidiThisValue;


    /**
     * 是否签收
     */

    @TableField(value = "kuaidi_types")
    private Integer kuaidiTypes;


    /**
     * 快递时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：快递单号
	 */
    public String getKuaidiNumber() {
        return kuaidiNumber;
    }


    /**
	 * 获取：快递单号
	 */

    public void setKuaidiNumber(String kuaidiNumber) {
        this.kuaidiNumber = kuaidiNumber;
    }
    /**
	 * 设置：运送物品
	 */
    public String getKuaidiName() {
        return kuaidiName;
    }


    /**
	 * 获取：运送物品
	 */

    public void setKuaidiName(String kuaidiName) {
        this.kuaidiName = kuaidiName;
    }
    /**
	 * 设置：快递金额
	 */
    public Integer getKuaidiMoney() {
        return kuaidiMoney;
    }


    /**
	 * 获取：快递金额
	 */

    public void setKuaidiMoney(Integer kuaidiMoney) {
        this.kuaidiMoney = kuaidiMoney;
    }
    /**
	 * 设置：快递详细内容
	 */
    public String getKuaidiContent() {
        return kuaidiContent;
    }


    /**
	 * 获取：快递详细内容
	 */

    public void setKuaidiContent(String kuaidiContent) {
        this.kuaidiContent = kuaidiContent;
    }
    /**
	 * 设置：快递最新物流状态
	 */
    public String getKuaidiThisValue() {
        return kuaidiThisValue;
    }


    /**
	 * 获取：快递最新物流状态
	 */

    public void setKuaidiThisValue(String kuaidiThisValue) {
        this.kuaidiThisValue = kuaidiThisValue;
    }
    /**
	 * 设置：是否签收
	 */
    public Integer getKuaidiTypes() {
        return kuaidiTypes;
    }


    /**
	 * 获取：是否签收
	 */

    public void setKuaidiTypes(Integer kuaidiTypes) {
        this.kuaidiTypes = kuaidiTypes;
    }
    /**
	 * 设置：快递时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：快递时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
