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

import com.entity.KuaidiEntity;

import com.service.KuaidiService;
import com.entity.view.KuaidiView;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.service.KuaidiListService;
import com.entity.KuaidiListEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 快递
 * 后端接口
 * @author
 * @email
 * @date 2021-04-16
*/
@RestController
@Controller
@RequestMapping("/kuaidi")
public class KuaidiController {
    private static final Logger logger = LoggerFactory.getLogger(KuaidiController.class);

    @Autowired
    private KuaidiService kuaidiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YonghuService yonghuService;
    // 列表详情的表级联service
    @Autowired
    private KuaidiListService kuaidiListService;
//    @Autowired
//    private YonghuService yonghuService;


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
        PageUtils page = kuaidiService.queryPage(params);

        //字典表数据转换
        List<KuaidiView> list =(List<KuaidiView>)page.getList();
        for(KuaidiView c:list){
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
        KuaidiEntity kuaidi = kuaidiService.selectById(id);
        if(kuaidi !=null){
            //entity转view
            KuaidiView view = new KuaidiView();
            BeanUtils.copyProperties( kuaidi , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(kuaidi.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody KuaidiEntity kuaidi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kuaidi:{}",this.getClass().getName(),kuaidi.toString());
        Wrapper<KuaidiEntity> queryWrapper = new EntityWrapper<KuaidiEntity>()
            .eq("kuaidi_number", kuaidi.getKuaidiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuaidiEntity kuaidiEntity = kuaidiService.selectOne(queryWrapper);
        if(kuaidiEntity==null){
            Date date = new Date();
            kuaidi.setInsertTime(date);
            kuaidi.setCreateTime(date);
            kuaidi.setKuaidiTypes(2);
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      kuaidi.set
        //  }
            kuaidiService.insert(kuaidi);
            KuaidiListEntity kuaidiListEntity = new KuaidiListEntity();
            kuaidiListEntity.setCreateTime(date);
            kuaidiListEntity.setInsertTime(date);
            kuaidiListEntity.setKuaidiId(kuaidi.getId());
            kuaidiListEntity.setKuaidiListName(kuaidi.getKuaidiName());
            kuaidiListService.insert(kuaidiListEntity);
            return R.ok();
        }else {
            return R.error(511,"快递编号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KuaidiEntity kuaidi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kuaidi:{}",this.getClass().getName(),kuaidi.toString());
        //根据字段查询是否有相同数据
        Wrapper<KuaidiEntity> queryWrapper = new EntityWrapper<KuaidiEntity>()
            .notIn("id",kuaidi.getId())
            .andNew()
            .eq("kuaidi_number", kuaidi.getKuaidiNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KuaidiEntity kuaidiEntity = kuaidiService.selectOne(queryWrapper);
        if(kuaidiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kuaidi.set
            //  }
            kuaidiService.updateById(kuaidi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"快递编号已经被使用");
        }
    }


    /**
    * 出出出出出出出出出出出出出出出
    */
    @RequestMapping("/outKuaidiList")
    public R outKuaidiList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outKuaidiList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        return R.ok();
    }

    /**
    * 入入入入入入入入入入入入入入入
    *//*
    @RequestMapping("/inKuaidiList")
    public R inKuaidiList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outKuaidiList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));


        Date date = new Date();//当前时间
        Integer userId = (Integer) request.getSession().getAttribute("userId");//当前登录人的id
        String tableName = (String) request.getSession().getAttribute("tableName");//当前登录人的表名
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);//当前登录人的信息
            //当前表的表级联查询
        String yonghuId = (String) params.get("yonghuId"); //用户
        String kuaidiName = (String) params.get("kuaidiName"); // 运送物品
        HashMap<String, Integer> map = (HashMap<String, Integer>) params.get("map");// id 和 数量
        if(map == null || map.size() ==0){
            return R.error("添加不能为空");
        }else{
            Set<String> ids = map.keySet(); // 获取添加数据的ids

                //添加当前列表
            KuaidiEntity kuaidiEntity = new KuaidiEntity();//新增订单
            kuaidiEntity.setYonghuId(Integer.valueOf(yonghuId));
            kuaidiEntity.setKuaidiNumber();
            kuaidiEntity.setKuaidiName(kuaidiName);
            kuaidiEntity.setKuaidiMoney();
            kuaidiEntity.setKuaidiThisValue();
            kuaidiEntity.setKuaidiTypes();
            kuaidiEntity.setInsertTime(date);
            kuaidiEntity.setCreateTime(date);
            kuaidiService.insert(kuaidiEntity);

                //详情表的添加
            List<KuaidiListEntity> kuaidiLists = new ArrayList<>();
            for(String i:ids){
                KuaidiListEntity entity = new KuaidiListEntity();
                entity.setKuaidiId(kuaidiEntity.getId());
                entity.setKuaidiListName();
                entity.setInsertTime(date);
                entity.setCreateTime(date);
                kuaidiLists.add(entity);
            }
            kuaidiListService.insertBatch(kuaidiLists);
            return R.ok();
        }
    }*/

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kuaidiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}

