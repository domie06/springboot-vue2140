package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.KaochangEntity;

import com.service.KaochangService;
import com.entity.view.KaochangView;
import com.service.KaoshiService;
import com.entity.KaoshiEntity;
import com.service.LaoshiService;
import com.entity.LaoshiEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 考场
 * 后端接口
 * @author
 * @email
 * @date 2021-03-23
*/
@RestController
@Controller
@RequestMapping("/kaochang")
public class KaochangController {
    private static final Logger logger = LoggerFactory.getLogger(KaochangController.class);

    @Autowired
    private KaochangService kaochangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    //级联表service
    @Autowired
    private KaoshiService kaoshiService;
    @Autowired
    private LaoshiService laoshiService;


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
        PageUtils page = kaochangService.queryPage(params);

        //字典表数据转换
        List<KaochangView> list =(List<KaochangView>)page.getList();
        for(KaochangView c:list){
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
        KaochangEntity kaochang = kaochangService.selectById(id);
        if(kaochang !=null){
            //entity转view
            KaochangView view = new KaochangView();
            BeanUtils.copyProperties( kaochang , view );//把实体数据重构到view中

            //级联表
            KaoshiEntity kaoshi = kaoshiService.selectById(kaochang.getKaoshiId());
            if(kaoshi != null){
                BeanUtils.copyProperties( kaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKaoshiId(kaoshi.getId());
            }
            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(kaochang.getLaoshiId());
            if(laoshi != null){
                BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setLaoshiId(laoshi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KaochangEntity kaochang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kaochang:{}",this.getClass().getName(),kaochang.toString());
        Wrapper<KaochangEntity> queryWrapper = new EntityWrapper<KaochangEntity>()
            .eq("kaoshi_id", kaochang.getKaoshiId())
            .eq("laoshi_id", kaochang.getLaoshiId())
            .orNew()
            .eq("kaochang_name",kaochang.getKaochangName());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaochangEntity kaochangEntity = kaochangService.selectOne(queryWrapper);
        if(kaochangEntity==null){
            kaochang.setCreateTime(new Date());
            kaochangService.insert(kaochang);
            return R.ok();
        }else {
            return R.error(511,"该老师已经参与本次考试监考了");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KaochangEntity kaochang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kaochang:{}",this.getClass().getName(),kaochang.toString());
        //根据字段查询是否有相同数据
        Wrapper<KaochangEntity> queryWrapper = new EntityWrapper<KaochangEntity>()
            .notIn("id",kaochang.getId())
            .andNew()
            .eq("kaoshi_id", kaochang.getKaoshiId())
            .eq("laoshi_id", kaochang.getLaoshiId())
            .orNew()
            .eq("kaochang_name",kaochang.getKaochangName());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KaochangEntity kaochangEntity = kaochangService.selectOne(queryWrapper);
        if(kaochangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kaochang.set
            //  }
            kaochangService.updateById(kaochang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该老师已经参与本次考试监考了");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kaochangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}

