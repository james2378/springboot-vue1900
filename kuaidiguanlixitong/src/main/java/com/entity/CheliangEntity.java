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
 * 车辆
 *
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("cheliang")
public class CheliangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheliangEntity() {

	}

	public CheliangEntity(T t) {
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
     * 车辆名字
     */
    @TableField(value = "cheliang_name")

    private String cheliangName;


    /**
     * 车辆类型
     */
    @TableField(value = "cheliang_leixing_types")

    private Integer cheliangLeixingTypes;


    /**
     * 车辆编号
     */
    @TableField(value = "cheliang_number")

    private String cheliangNumber;


    /**
     * 车辆详情
     */
    @TableField(value = "cheliang_content")

    private String cheliangContent;


    /**
     * 是否使用
     */
    @TableField(value = "cheliang_types")

    private Integer cheliangTypes;


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
	 * 设置：车辆名字
	 */
    public String getCheliangName() {
        return cheliangName;
    }


    /**
	 * 获取：车辆名字
	 */

    public void setCheliangName(String cheliangName) {
        this.cheliangName = cheliangName;
    }
    /**
	 * 设置：车辆类型
	 */
    public Integer getCheliangLeixingTypes() {
        return cheliangLeixingTypes;
    }


    /**
	 * 获取：车辆类型
	 */

    public void setCheliangLeixingTypes(Integer cheliangLeixingTypes) {
        this.cheliangLeixingTypes = cheliangLeixingTypes;
    }
    /**
	 * 设置：车辆编号
	 */
    public String getCheliangNumber() {
        return cheliangNumber;
    }


    /**
	 * 获取：车辆编号
	 */

    public void setCheliangNumber(String cheliangNumber) {
        this.cheliangNumber = cheliangNumber;
    }
    /**
	 * 设置：车辆详情
	 */
    public String getCheliangContent() {
        return cheliangContent;
    }


    /**
	 * 获取：车辆详情
	 */

    public void setCheliangContent(String cheliangContent) {
        this.cheliangContent = cheliangContent;
    }
    /**
	 * 设置：是否使用
	 */
    public Integer getCheliangTypes() {
        return cheliangTypes;
    }


    /**
	 * 获取：是否使用
	 */

    public void setCheliangTypes(Integer cheliangTypes) {
        this.cheliangTypes = cheliangTypes;
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
        return "Cheliang{" +
            "id=" + id +
            ", cheliangName=" + cheliangName +
            ", cheliangLeixingTypes=" + cheliangLeixingTypes +
            ", cheliangNumber=" + cheliangNumber +
            ", cheliangContent=" + cheliangContent +
            ", cheliangTypes=" + cheliangTypes +
            ", createTime=" + createTime +
        "}";
    }
}
