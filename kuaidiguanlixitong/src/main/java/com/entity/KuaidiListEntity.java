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
 * 快递详情
 *
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("kuaidi_list")
public class KuaidiListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KuaidiListEntity() {

	}

	public KuaidiListEntity(T t) {
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
     * 快递
     */
    @TableField(value = "kuaidi_id")

    private Integer kuaidiId;


    /**
     * 物流状态
     */
    @TableField(value = "kuaidi_list_name")

    private String kuaidiListName;


    /**
     * 时间
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
	 * 设置：快递
	 */
    public Integer getKuaidiId() {
        return kuaidiId;
    }


    /**
	 * 获取：快递
	 */

    public void setKuaidiId(Integer kuaidiId) {
        this.kuaidiId = kuaidiId;
    }
    /**
	 * 设置：物流状态
	 */
    public String getKuaidiListName() {
        return kuaidiListName;
    }


    /**
	 * 获取：物流状态
	 */

    public void setKuaidiListName(String kuaidiListName) {
        this.kuaidiListName = kuaidiListName;
    }
    /**
	 * 设置：时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：时间
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
        return "KuaidiList{" +
            "id=" + id +
            ", kuaidiId=" + kuaidiId +
            ", kuaidiListName=" + kuaidiListName +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
