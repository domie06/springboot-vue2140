package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.KaochangDao;
import com.entity.KaochangEntity;
import com.service.KaochangService;
import com.entity.view.KaochangView;

/**
 * 考场 服务实现类
 * @author 
 * @since 2021-03-23
 */
@Service("kaochangService")
@Transactional
public class KaochangServiceImpl extends ServiceImpl<KaochangDao, KaochangEntity> implements KaochangService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KaochangView> page =new Query<KaochangView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
