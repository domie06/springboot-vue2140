package com.entity.vo;

import com.entity.KaochangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 考场
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-23
 */
@TableName("kaochang")
public class KaochangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 考试
     */

    @TableField(value = "kaoshi_id")
    private Integer kaoshiId;


    /**
     * 监考老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 考场名
     */

    @TableField(value = "kaochang_name")
    private String kaochangName;


    /**
     * 考场人数
     */

    @TableField(value = "kaoshi_number")
    private Integer kaoshiNumber;


    /**
     * 考场地址
     */

    @TableField(value = "kaochang_address")
    private String kaochangAddress;


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
	 * 设置：考试
	 */
    public Integer getKaoshiId() {
        return kaoshiId;
    }


    /**
	 * 获取：考试
	 */

    public void setKaoshiId(Integer kaoshiId) {
        this.kaoshiId = kaoshiId;
    }
    /**
	 * 设置：监考老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：监考老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：考场名
	 */
    public String getKaochangName() {
        return kaochangName;
    }


    /**
	 * 获取：考场名
	 */

    public void setKaochangName(String kaochangName) {
        this.kaochangName = kaochangName;
    }
    /**
	 * 设置：考场人数
	 */
    public Integer getKaoshiNumber() {
        return kaoshiNumber;
    }


    /**
	 * 获取：考场人数
	 */

    public void setKaoshiNumber(Integer kaoshiNumber) {
        this.kaoshiNumber = kaoshiNumber;
    }
    /**
	 * 设置：考场地址
	 */
    public String getKaochangAddress() {
        return kaochangAddress;
    }


    /**
	 * 获取：考场地址
	 */

    public void setKaochangAddress(String kaochangAddress) {
        this.kaochangAddress = kaochangAddress;
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
