package com.entity.vo;

import com.entity.CheliangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("cheliang")
public class CheliangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
