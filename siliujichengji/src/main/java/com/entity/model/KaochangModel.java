package com.entity.model;

import com.entity.KaochangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 考场
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-23
 */
public class KaochangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：考试
	 */
    public Integer getKaoshiId() {
        return kaoshiId;
    }


    /**
	 * 设置：考试
	 */
    public void setKaoshiId(Integer kaoshiId) {
        this.kaoshiId = kaoshiId;
    }
    /**
	 * 获取：监考老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：监考老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：考场名
	 */
    public String getKaochangName() {
        return kaochangName;
    }


    /**
	 * 设置：考场名
	 */
    public void setKaochangName(String kaochangName) {
        this.kaochangName = kaochangName;
    }
    /**
	 * 获取：考场人数
	 */
    public Integer getKaoshiNumber() {
        return kaoshiNumber;
    }


    /**
	 * 设置：考场人数
	 */
    public void setKaoshiNumber(Integer kaoshiNumber) {
        this.kaoshiNumber = kaoshiNumber;
    }
    /**
	 * 获取：考场地址
	 */
    public String getKaochangAddress() {
        return kaochangAddress;
    }


    /**
	 * 设置：考场地址
	 */
    public void setKaochangAddress(String kaochangAddress) {
        this.kaochangAddress = kaochangAddress;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
