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
 * 车辆调度
 *
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("diaodu")
public class DiaoduEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DiaoduEntity() {

	}

	public DiaoduEntity(T t) {
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
     * 车辆
     */
    @TableField(value = "cheliang_id")

    private Integer cheliangId;


    /**
     * 始发站
     */
    @TableField(value = "diaodu_start")

    private String diaoduStart;


    /**
     * 目的地
     */
    @TableField(value = "diaodu_end")

    private String diaoduEnd;


    /**
     * 是否使用
     */
    @TableField(value = "diaodu_types")

    private Integer diaoduTypes;


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
	 * 设置：车辆
	 */
    public Integer getCheliangId() {
        return cheliangId;
    }


    /**
	 * 获取：车辆
	 */

    public void setCheliangId(Integer cheliangId) {
        this.cheliangId = cheliangId;
    }
    /**
	 * 设置：始发站
	 */
    public String getDiaoduStart() {
        return diaoduStart;
    }


    /**
	 * 获取：始发站
	 */

    public void setDiaoduStart(String diaoduStart) {
        this.diaoduStart = diaoduStart;
    }
    /**
	 * 设置：目的地
	 */
    public String getDiaoduEnd() {
        return diaoduEnd;
    }


    /**
	 * 获取：目的地
	 */

    public void setDiaoduEnd(String diaoduEnd) {
        this.diaoduEnd = diaoduEnd;
    }
    /**
	 * 设置：是否使用
	 */
    public Integer getDiaoduTypes() {
        return diaoduTypes;
    }


    /**
	 * 获取：是否使用
	 */

    public void setDiaoduTypes(Integer diaoduTypes) {
        this.diaoduTypes = diaoduTypes;
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
        return "Diaodu{" +
            "id=" + id +
            ", cheliangId=" + cheliangId +
            ", diaoduStart=" + diaoduStart +
            ", diaoduEnd=" + diaoduEnd +
            ", diaoduTypes=" + diaoduTypes +
            ", createTime=" + createTime +
        "}";
    }
}
