package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 快递
 *
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("kuaidi")
public class KuaidiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KuaidiEntity() {

	}

	public KuaidiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Kuaidi{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", kuaidiNumber=" + kuaidiNumber +
            ", kuaidiName=" + kuaidiName +
            ", kuaidiMoney=" + kuaidiMoney +
            ", kuaidiContent=" + kuaidiContent +
            ", kuaidiThisValue=" + kuaidiThisValue +
            ", kuaidiTypes=" + kuaidiTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
