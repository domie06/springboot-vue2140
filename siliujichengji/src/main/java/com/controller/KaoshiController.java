package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.ChengjiEntity;
import com.entity.KaochangEntity;
import com.entity.LaoshiEntity;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.KaoshiEntity;

import com.entity.view.KaoshiView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 考试
 * 后端接口
 * @author
 * @email
 * @date 2021-03-23
 */
@RestController
@Controller
@RequestMapping("/kaoshi")
public class KaoshiController {
    private static final Logger logger = LoggerFactory.getLogger(KaoshiController.class);

    @Autowired
    private KaoshiService kaoshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private LaoshiService laoshiService;
    @Autowired
    private KaochangService kaochangService;
    @Autowired
    private ChengjiService chengjiService;


    //级联表service


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        PageUtils page = kaoshiService.queryPage(params);

        //字典表数据转换
        List<KaoshiView> list =(List<KaoshiView>)page.getList();
        for(KaoshiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KaoshiEntity kaoshi = kaoshiService.selectById(id);
        if(kaoshi !=null){
            //entity转view
            KaoshiView view = new KaoshiView();
            BeanUtils.copyProperties( kaoshi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
     * 保存考试并且默认添加两个考场
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaoshiEntity kaoshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaoshi:{}",this.getClass().getName(),kaoshi.toString());
        Wrapper<KaoshiEntity> queryWrapper = new EntityWrapper<KaoshiEntity>()
                .eq("kaoshi_name", kaoshi.getKaoshiName())
                .eq("kaoshi_types", kaoshi.getKaoshiTypes())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoshiEntity kaoshiEntity = kaoshiService.selectOne(queryWrapper);
        if(kaoshiEntity==null){
            if((kaoshi.getEndTime().getTime()-kaoshi.getStartTime().getTime())<=0){
                return R.error("考试结束时间不能小于开始时间");
            }
            Date date = new Date();
            kaoshi.setCreateTime(date);
            kaoshiService.insert(kaoshi);

            List<LaoshiEntity> laoshiEntities = laoshiService.selectList(new EntityWrapper<LaoshiEntity>());
            if(laoshiEntities.size()>1){
                Integer laoshiIndex1;
                Integer laoshiIndex2;
                if(laoshiEntities.size()==2){
                    laoshiIndex1=1;
                    laoshiIndex2=2;
                }else{
                    Random random = new Random();
                    laoshiIndex1 = random.nextInt(laoshiEntities.size()-1);
                    laoshiIndex2 = random.nextInt(laoshiEntities.size()-1);
                    boolean flag=true;
                    while (flag){
                        if(laoshiIndex1.intValue() == laoshiIndex2.intValue()){
                            laoshiIndex2 = random.nextInt(laoshiEntities.size()-1);
                        }else{
                            flag =false;
                        }
                    }
                }
                //默认添加考场
                List<KaochangEntity> kaochangEntityList = new ArrayList<>();
                KaochangEntity kaochang1 = new KaochangEntity();
                kaochang1.setCreateTime(date);
                kaochang1.setKaochangAddress("长椿路第一考场");
                kaochang1.setKaochangName(kaoshi.getKaoshiName()+"的第一考场");
                kaochang1.setKaoshiId(kaoshi.getId());
                kaochang1.setKaoshiNumber(0);
                kaochang1.setLaoshiId(laoshiEntities.get(laoshiIndex1).getId());
                kaochangEntityList.add(kaochang1);

                KaochangEntity kaochang2 = new KaochangEntity();
                kaochang2.setCreateTime(date);
                kaochang2.setKaochangAddress("长椿路第二考场");
                kaochang2.setKaochangName(kaoshi.getKaoshiName()+"的第二考场");
                kaochang2.setKaoshiId(kaoshi.getId());
                kaochang2.setKaoshiNumber(0);
                kaochang2.setLaoshiId(laoshiEntities.get(laoshiIndex2).getId());
                kaochangEntityList.add(kaochang2);

                kaochangService.insertBatch(kaochangEntityList);
                return R.ok();
            }else{
                return R.error("老师数量过少,生成不出两个考场");
            }
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KaoshiEntity kaoshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaoshi:{}",this.getClass().getName(),kaoshi.toString());
        //根据字段查询是否有相同数据
        Wrapper<KaoshiEntity> queryWrapper = new EntityWrapper<KaoshiEntity>()
                .notIn("id",kaoshi.getId())
                .andNew()
                .eq("kaoshi_name", kaoshi.getKaoshiName())
                .eq("kaoshi_types", kaoshi.getKaoshiTypes())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaoshiEntity kaoshiEntity = kaoshiService.selectOne(queryWrapper);
        kaoshi.setStartTime(new Date());
        kaoshi.setEndTime(new Date());
        if(kaoshiEntity==null){
            if((kaoshi.getEndTime().getTime()-kaoshi.getStartTime().getTime())<0){
                return R.error("考试结束时间不能小于开始时间");
            }
            kaoshiService.updateById(kaoshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 报名
     */
    @RequestMapping("/baoming")
    public R baoming(@RequestParam Integer kaoshiId, HttpServletRequest request){
        logger.debug("baoming方法:,,Controller:{},,kaoshiId:{}",this.getClass().getName(),kaoshiId);

        String role = String.valueOf(request.getSession().getAttribute("role"));
        Integer userId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        if("用户".equals(role)){
            KaoshiEntity kaoshiEntity = kaoshiService.selectById(kaoshiId);
            if(kaoshiEntity != null){
                Integer kaoshiTypes = kaoshiEntity.getKaoshiTypes();
                if(kaoshiTypes.intValue() ==1){
                    ChengjiEntity one = chengjiService.selectOne(new EntityWrapper<ChengjiEntity>().eq("yonghu_id", userId).eq("chengji_types", 3).eq("kaoshi_types",1));
                    if(one!=null){
                        return R.error("您已经考过四级考试了");
                    }
                    List<KaochangEntity> kaoChangs = kaochangService.selectList(new EntityWrapper<KaochangEntity>().eq("kaoshi_id", kaoshiEntity.getId()));
                    List<Integer> ids = new ArrayList<>();
                    for(KaochangEntity k:kaoChangs){
                        ids.add(k.getId());
                    }
                    if(ids != null && ids.size()>0){
                        List<ChengjiEntity> chengjiEntities = chengjiService.selectList(new EntityWrapper<ChengjiEntity>().eq("yonghu_id", userId).in("kaochang_id", ids));
                        if(chengjiEntities.size()>0){
                            return R.error("您已经参加过本次考试了");
                        }
                    }
                    //查询出当前考试的考场人数小于20的考场
                    List<KaochangEntity> kaochangEntityList = kaochangService.selectList(new EntityWrapper<KaochangEntity>().eq("kaoshi_id", kaoshiEntity.getId()).between("kaoshi_number", 0, 19));
                    if( kaochangEntityList == null || kaochangEntityList.size()==0 ){
                        return R.error("可用考场为空");
                    }else{
                        //随机获取一个可用考场
                        KaochangEntity kaochangEntity = kaochangEntityList.get(new Random().nextInt(kaochangEntityList.size() - 1));
                        kaochangEntity.setKaoshiNumber(kaochangEntity.getKaoshiNumber()+1);
                        kaochangService.updateById(kaochangEntity);

                        // 新增成绩 成绩类型为报名
                        ChengjiEntity chengjiEntity = new ChengjiEntity();
                        chengjiEntity.setCreateTime(new Date());
                        chengjiEntity.setChengjiTypes(1);
                        chengjiEntity.setFraction(null);
                        chengjiEntity.setKaochangId(kaochangEntity.getId());
                        chengjiEntity.setYonghuId(userId);
                        chengjiEntity.setKaoshiTypes(1);
                        chengjiService.insert(chengjiEntity);
                    }
                }else if(kaoshiTypes.intValue() ==2){
                    //查出该用户是否存在四级考试合格
                    ChengjiEntity one = chengjiService.selectOne(new EntityWrapper<ChengjiEntity>().eq("yonghu_id", userId).eq("chengji_types", 3).eq("kaoshi_types",1));
                    if(one ==null){
                        return R.error("您先参加四级考试才能参与六级考试");
                    }
                    one = chengjiService.selectOne(new EntityWrapper<ChengjiEntity>().eq("yonghu_id", userId).eq("chengji_types", 3).eq("kaoshi_types",2));
                    if(one!=null){
                        return R.error("您已经考过六级考试了");
                    }

                    List<KaochangEntity> kaoChangs = kaochangService.selectList(new EntityWrapper<KaochangEntity>().eq("kaoshi_id", kaoshiEntity.getId()));
                    List<Integer> ids = new ArrayList<>();
                    for(KaochangEntity k:kaoChangs){
                        ids.add(k.getId());
                    }
                    if(ids != null && ids.size()>0){
                        List<ChengjiEntity> chengjiEntities = chengjiService.selectList(new EntityWrapper<ChengjiEntity>().eq("yonghu_id", userId).in("kaochang_id", ids));
                        if(chengjiEntities.size()>0){
                            return R.error("您已经参加过本次考试了");
                        }
                    }

                    //查询出当前考试的考场人数小于20的考场
                    List<KaochangEntity> kaochangEntityList = kaochangService.selectList(new EntityWrapper<KaochangEntity>().eq("kaoshi_id", kaoshiEntity.getId()).between("kaoshi_number", 0, 19));
                    if( kaochangEntityList == null || kaochangEntityList.size()==0 ){
                        return R.error("可用考场为空");
                    }else{
                        //随机获取一个可用考场
                        KaochangEntity kaochangEntity = kaochangEntityList.get(new Random().nextInt(kaochangEntityList.size() - 1));
                        kaochangEntity.setKaoshiNumber(kaochangEntity.getKaoshiNumber()+1);
                        kaochangService.updateById(kaochangEntity);

                        // 新增成绩 成绩类型为报名
                        ChengjiEntity chengjiEntity = new ChengjiEntity();
                        chengjiEntity.setCreateTime(new Date());
                        chengjiEntity.setChengjiTypes(1);
                        chengjiEntity.setFraction(null);
                        chengjiEntity.setKaochangId(kaochangEntity.getId());
                        chengjiEntity.setYonghuId(userId);
                        chengjiEntity.setKaoshiTypes(2);
                        chengjiService.insert(chengjiEntity);
                    }
                }else{
                    return R.error("考试类型不正确");
                }
                return R.ok();
            }else{
                return R.error("查不到考试");
            }
        }else{
            return R.error("您没有权限报名考试");
        }
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaoshiService.deleteBatchIds(Arrays.asList(ids));
        kaochangService.delete(new EntityWrapper<KaochangEntity>().in("kaoshi_id",ids));
        return R.ok();
    }


}

