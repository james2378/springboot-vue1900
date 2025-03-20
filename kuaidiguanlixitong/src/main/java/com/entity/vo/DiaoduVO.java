package com.entity.vo;

import com.entity.DiaoduEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆调度
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("diaodu")
public class DiaoduVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
