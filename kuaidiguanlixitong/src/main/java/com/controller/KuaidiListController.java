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

import com.entity.KuaidiListEntity;

import com.service.KuaidiListService;
import com.entity.view.KuaidiListView;
import com.service.KuaidiService;
import com.entity.KuaidiEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 快递详情
 * 后端接口
 * @author
 * @email
 * @date 2021-04-16
*/
@RestController
@Controller
@RequestMapping("/kuaidiList")
public class KuaidiListController {
    private static final Logger logger = LoggerFactory.getLogger(KuaidiListController.class);

    @Autowired
    private KuaidiListService kuaidiListService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private KuaidiService kuaidiService;


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
        params.put("orderBy","id");
        PageUtils page = kuaidiListService.queryPage(params);

        //字典表数据转换
        List<KuaidiListView> list =(List<KuaidiListView>)page.getList();
        for(KuaidiListView c:list){
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
        KuaidiListEntity kuaidiList = kuaidiListService.selectById(id);
        if(kuaidiList !=null){
            //entity转view
            KuaidiListView view = new KuaidiListView();
            BeanUtils.copyProperties( kuaidiList , view );//把实体数据重构到view中

            //级联表
            KuaidiEntity kuaidi = kuaidiService.selectById(kuaidiList.getKuaidiId());
            if(kuaidi != null){
                BeanUtils.copyProperties( kuaidi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKuaidiId(kuaidi.getId());
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
    public R save(@RequestBody KuaidiListEntity kuaidiList, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kuaidiList:{}",this.getClass().getName(),kuaidiList.toString());
        Wrapper<KuaidiListEntity> queryWrapper = new EntityWrapper<KuaidiListEntity>()
            .eq("kuaidi_id", kuaidiList.getKuaidiId())
            .eq("kuaidi_list_name", kuaidiList.getKuaidiListName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuaidiListEntity kuaidiListEntity = kuaidiListService.selectOne(queryWrapper);
        if(kuaidiListEntity==null){
            kuaidiList.setInsertTime(new Date());
            kuaidiList.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      kuaidiList.set
        //  }
            kuaidiListService.insert(kuaidiList);
            Integer kuaidiId = kuaidiList.getKuaidiId();
            KuaidiEntity kuaidiEntity = kuaidiService.selectById(kuaidiId);
            String kuaidiListName = kuaidiList.getKuaidiListName();
            if(kuaidiListName.contains("签收")){
                kuaidiEntity.setKuaidiTypes(1);
            }
            kuaidiEntity.setKuaidiThisValue(kuaidiListName);
            kuaidiService.updateById(kuaidiEntity);//更新快递信息,更新快递最新物流
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuaidiListEntity kuaidiList, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kuaidiList:{}",this.getClass().getName(),kuaidiList.toString());
        //根据字段查询是否有相同数据
        Wrapper<KuaidiListEntity> queryWrapper = new EntityWrapper<KuaidiListEntity>()
            .notIn("id",kuaidiList.getId())
            .andNew()
            .eq("kuaidi_id", kuaidiList.getKuaidiId())
            .eq("kuaidi_list_name", kuaidiList.getKuaidiListName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuaidiListEntity kuaidiListEntity = kuaidiListService.selectOne(queryWrapper);
        if(kuaidiListEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kuaidiList.set
            //  }
            kuaidiListService.updateById(kuaidiList);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kuaidiListService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}

