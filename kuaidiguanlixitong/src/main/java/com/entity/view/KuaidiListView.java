package com.entity.view;

import com.entity.KuaidiListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 快递详情
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("kuaidi_list")
public class KuaidiListView extends KuaidiListEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 kuaidi
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
				* 是否签收的值
				*/
				private String kuaidiValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 快递时间
			*/
			private Date insertTime;

	public KuaidiListView() {

	}

	public KuaidiListView(KuaidiListEntity kuaidiListEntity) {
		try {
			BeanUtils.copyProperties(this, kuaidiListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set kuaidi
					/**
					* 获取： 用户
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 用户
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 快递单号
					*/
					public String getKuaidiNumber() {
						return kuaidiNumber;
					}
					/**
					* 设置： 快递单号
					*/
					public void setKuaidiNumber(String kuaidiNumber) {
						this.kuaidiNumber = kuaidiNumber;
					}
					/**
					* 获取： 运送物品
					*/
					public String getKuaidiName() {
						return kuaidiName;
					}
					/**
					* 设置： 运送物品
					*/
					public void setKuaidiName(String kuaidiName) {
						this.kuaidiName = kuaidiName;
					}
					/**
					* 获取： 快递金额
					*/
					public Integer getKuaidiMoney() {
						return kuaidiMoney;
					}
					/**
					* 设置： 快递金额
					*/
					public void setKuaidiMoney(Integer kuaidiMoney) {
						this.kuaidiMoney = kuaidiMoney;
					}
					/**
					* 获取： 快递详细内容
					*/
					public String getKuaidiContent() {
						return kuaidiContent;
					}
					/**
					* 设置： 快递详细内容
					*/
					public void setKuaidiContent(String kuaidiContent) {
						this.kuaidiContent = kuaidiContent;
					}
					/**
					* 获取： 快递最新物流状态
					*/
					public String getKuaidiThisValue() {
						return kuaidiThisValue;
					}
					/**
					* 设置： 快递最新物流状态
					*/
					public void setKuaidiThisValue(String kuaidiThisValue) {
						this.kuaidiThisValue = kuaidiThisValue;
					}
					/**
					* 获取： 是否签收
					*/
					public Integer getKuaidiTypes() {
						return kuaidiTypes;
					}
					/**
					* 设置： 是否签收
					*/
					public void setKuaidiTypes(Integer kuaidiTypes) {
						this.kuaidiTypes = kuaidiTypes;
					}


						/**
						* 获取： 是否签收的值
						*/
						public String getKuaidiValue() {
							return kuaidiValue;
						}
						/**
						* 设置： 是否签收的值
						*/
						public void setKuaidiValue(String kuaidiValue) {
							this.kuaidiValue = kuaidiValue;
						}
					/**
					* 获取： 快递时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 快递时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}










}
