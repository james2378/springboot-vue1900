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

import com.dao.KuaidiListDao;
import com.entity.KuaidiListEntity;
import com.service.KuaidiListService;
import com.entity.view.KuaidiListView;

/**
 * 快递详情 服务实现类
 * @author 
 * @since 2021-04-16
 */
@Service("kuaidiListService")
@Transactional
public class KuaidiListServiceImpl extends ServiceImpl<KuaidiListDao, KuaidiListEntity> implements KuaidiListService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KuaidiListView> page =new Query<KuaidiListView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
