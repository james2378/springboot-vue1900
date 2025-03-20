package com.entity.view;

import com.entity.DiaoduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆调度
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-16
 */
@TableName("diaodu")
public class DiaoduView extends DiaoduEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否使用的值
		*/
		private String diaoduValue;



		//级联表 cheliang
			/**
			* 车辆名字
			*/
			private String cheliangName;
			/**
			* 车辆类型
			*/
			private Integer cheliangLeixingTypes;
				/**
				* 车辆类型的值
				*/
				private String cheliangLeixingValue;
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
				* 是否使用的值
				*/
				private String cheliangValue;

	public DiaoduView() {

	}

	public DiaoduView(DiaoduEntity diaoduEntity) {
		try {
			BeanUtils.copyProperties(this, diaoduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否使用的值
			*/
			public String getDiaoduValue() {
				return diaoduValue;
			}
			/**
			* 设置： 是否使用的值
			*/
			public void setDiaoduValue(String diaoduValue) {
				this.diaoduValue = diaoduValue;
			}




				//级联表的get和set cheliang
					/**
					* 获取： 车辆名字
					*/
					public String getCheliangName() {
						return cheliangName;
					}
					/**
					* 设置： 车辆名字
					*/
					public void setCheliangName(String cheliangName) {
						this.cheliangName = cheliangName;
					}
					/**
					* 获取： 车辆类型
					*/
					public Integer getCheliangLeixingTypes() {
						return cheliangLeixingTypes;
					}
					/**
					* 设置： 车辆类型
					*/
					public void setCheliangLeixingTypes(Integer cheliangLeixingTypes) {
						this.cheliangLeixingTypes = cheliangLeixingTypes;
					}


						/**
						* 获取： 车辆类型的值
						*/
						public String getCheliangLeixingValue() {
							return cheliangLeixingValue;
						}
						/**
						* 设置： 车辆类型的值
						*/
						public void setCheliangLeixingValue(String cheliangLeixingValue) {
							this.cheliangLeixingValue = cheliangLeixingValue;
						}
					/**
					* 获取： 车辆编号
					*/
					public String getCheliangNumber() {
						return cheliangNumber;
					}
					/**
					* 设置： 车辆编号
					*/
					public void setCheliangNumber(String cheliangNumber) {
						this.cheliangNumber = cheliangNumber;
					}
					/**
					* 获取： 车辆详情
					*/
					public String getCheliangContent() {
						return cheliangContent;
					}
					/**
					* 设置： 车辆详情
					*/
					public void setCheliangContent(String cheliangContent) {
						this.cheliangContent = cheliangContent;
					}
					/**
					* 获取： 是否使用
					*/
					public Integer getCheliangTypes() {
						return cheliangTypes;
					}
					/**
					* 设置： 是否使用
					*/
					public void setCheliangTypes(Integer cheliangTypes) {
						this.cheliangTypes = cheliangTypes;
					}


						/**
						* 获取： 是否使用的值
						*/
						public String getCheliangValue() {
							return cheliangValue;
						}
						/**
						* 设置： 是否使用的值
						*/
						public void setCheliangValue(String cheliangValue) {
							this.cheliangValue = cheliangValue;
						}
















}
