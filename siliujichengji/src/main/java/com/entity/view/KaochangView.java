package com.entity.view;

import com.entity.KaochangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 考场
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("kaochang")
public class KaochangView extends KaochangEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 kaoshi
			/**
			* 考试名
			*/
			private String kaoshiName;
			/**
			* 考试类型
			*/
			private Integer kaoshiTypes;
				/**
				* 考试类型的值
				*/
				private String kaoshiValue;
			/**
			* 开始时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			private Date startTime;
			/**
			* 结束时间
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			private Date endTime;

		//级联表 laoshi
			/**
			* 账户
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 姓名
			*/
			private String laoshiName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 身份证号
			*/
			private String laoshiIdNumber;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 照片
			*/
			private String laoshiPhoto;
			/**
			* 民族
			*/
			private String laoshiNation;
			/**
			* 政治面貌
			*/
			private Integer politicsTypes;
				/**
				* 政治面貌的值
				*/
				private String politicsValue;
			/**
			* 家庭住址
			*/
			private String laoshiAddress;

	public KaochangView() {

	}

	public KaochangView(KaochangEntity kaochangEntity) {
		try {
			BeanUtils.copyProperties(this, kaochangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
















				//级联表的get和set kaoshi
					/**
					* 获取： 考试名
					*/
					public String getKaoshiName() {
						return kaoshiName;
					}
					/**
					* 设置： 考试名
					*/
					public void setKaoshiName(String kaoshiName) {
						this.kaoshiName = kaoshiName;
					}
					/**
					* 获取： 考试类型
					*/
					public Integer getKaoshiTypes() {
						return kaoshiTypes;
					}
					/**
					* 设置： 考试类型
					*/
					public void setKaoshiTypes(Integer kaoshiTypes) {
						this.kaoshiTypes = kaoshiTypes;
					}


						/**
						* 获取： 考试类型的值
						*/
						public String getKaoshiValue() {
							return kaoshiValue;
						}
						/**
						* 设置： 考试类型的值
						*/
						public void setKaoshiValue(String kaoshiValue) {
							this.kaoshiValue = kaoshiValue;
						}
					/**
					* 获取： 开始时间
					*/
					public Date getStartTime() {
						return startTime;
					}
					/**
					* 设置： 开始时间
					*/
					public void setStartTime(Date startTime) {
						this.startTime = startTime;
					}
					/**
					* 获取： 结束时间
					*/
					public Date getEndTime() {
						return endTime;
					}
					/**
					* 设置： 结束时间
					*/
					public void setEndTime(Date endTime) {
						this.endTime = endTime;
					}




				//级联表的get和set laoshi
					/**
					* 获取： 账户
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账户
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getLaoshiIdNumber() {
						return laoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setLaoshiIdNumber(String laoshiIdNumber) {
						this.laoshiIdNumber = laoshiIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 照片
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}
					/**
					* 获取： 民族
					*/
					public String getLaoshiNation() {
						return laoshiNation;
					}
					/**
					* 设置： 民族
					*/
					public void setLaoshiNation(String laoshiNation) {
						this.laoshiNation = laoshiNation;
					}
					/**
					* 获取： 政治面貌
					*/
					public Integer getPoliticsTypes() {
						return politicsTypes;
					}
					/**
					* 设置： 政治面貌
					*/
					public void setPoliticsTypes(Integer politicsTypes) {
						this.politicsTypes = politicsTypes;
					}


						/**
						* 获取： 政治面貌的值
						*/
						public String getPoliticsValue() {
							return politicsValue;
						}
						/**
						* 设置： 政治面貌的值
						*/
						public void setPoliticsValue(String politicsValue) {
							this.politicsValue = politicsValue;
						}
					/**
					* 获取： 家庭住址
					*/
					public String getLaoshiAddress() {
						return laoshiAddress;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setLaoshiAddress(String laoshiAddress) {
						this.laoshiAddress = laoshiAddress;
					}









}
