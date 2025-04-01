package com.entity.view;

import com.entity.ChengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 成绩
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("chengji")
public class ChengjiView extends ChengjiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 考试类型的值
		*/
		private String kaoshiValue;
		/**
		* 成绩类型的值
		*/
		private String chengjiValue;



		//级联表 kaochang
			/**
			* 考试
			*/
			private Integer kaoshiId;
			/**
			* 监考老师
			*/
			private Integer laoshiId;
			/**
			* 考场名
			*/
			private String kaochangName;
			/**
			* 考场人数
			*/
			private Integer kaoshiNumber;
			/**
			* 考场地址
			*/
			private String kaochangAddress;

		//级联表 yonghu
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
			private String name;
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
			private String idNumber;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 照片
			*/
			private String yonghuPhoto;
			/**
			* 民族
			*/
			private String nation;
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
			private String address;

	public ChengjiView() {

	}

	public ChengjiView(ChengjiEntity chengjiEntity) {
		try {
			BeanUtils.copyProperties(this, chengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			* 获取： 成绩类型的值
			*/
			public String getChengjiValue() {
				return chengjiValue;
			}
			/**
			* 设置： 成绩类型的值
			*/
			public void setChengjiValue(String chengjiValue) {
				this.chengjiValue = chengjiValue;
			}











				//级联表的get和set kaochang
					/**
					* 获取： 考试
					*/
					public Integer getKaoshiId() {
						return kaoshiId;
					}
					/**
					* 设置： 考试
					*/
					public void setKaoshiId(Integer kaoshiId) {
						this.kaoshiId = kaoshiId;
					}
					/**
					* 获取： 监考老师
					*/
					public Integer getLaoshiId() {
						return laoshiId;
					}
					/**
					* 设置： 监考老师
					*/
					public void setLaoshiId(Integer laoshiId) {
						this.laoshiId = laoshiId;
					}
					/**
					* 获取： 考场名
					*/
					public String getKaochangName() {
						return kaochangName;
					}
					/**
					* 设置： 考场名
					*/
					public void setKaochangName(String kaochangName) {
						this.kaochangName = kaochangName;
					}
					/**
					* 获取： 考场人数
					*/
					public Integer getKaoshiNumber() {
						return kaoshiNumber;
					}
					/**
					* 设置： 考场人数
					*/
					public void setKaoshiNumber(Integer kaoshiNumber) {
						this.kaoshiNumber = kaoshiNumber;
					}
					/**
					* 获取： 考场地址
					*/
					public String getKaochangAddress() {
						return kaochangAddress;
					}
					/**
					* 设置： 考场地址
					*/
					public void setKaochangAddress(String kaochangAddress) {
						this.kaochangAddress = kaochangAddress;
					}











				//级联表的get和set yonghu
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
					public String getName() {
						return name;
					}
					/**
					* 设置： 姓名
					*/
					public void setName(String name) {
						this.name = name;
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
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
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
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 民族
					*/
					public String getNation() {
						return nation;
					}
					/**
					* 设置： 民族
					*/
					public void setNation(String nation) {
						this.nation = nation;
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
					public String getAddress() {
						return address;
					}
					/**
					* 设置： 家庭住址
					*/
					public void setAddress(String address) {
						this.address = address;
					}




}
