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

import com.entity.DiaoduEntity;

import com.service.DiaoduService;
import com.entity.view.DiaoduView;
import com.service.CheliangService;
import com.entity.CheliangEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 车辆调度
 * 后端接口
 * @author
 * @email
 * @date 2021-04-16
*/
@RestController
@Controller
@RequestMapping("/diaodu")
public class DiaoduController {
    private static final Logger logger = LoggerFactory.getLogger(DiaoduController.class);

    @Autowired
    private DiaoduService diaoduService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private CheliangService cheliangService;


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
        PageUtils page = diaoduService.queryPage(params);

        //字典表数据转换
        List<DiaoduView> list =(List<DiaoduView>)page.getList();
        for(DiaoduView c:list){
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
        DiaoduEntity diaodu = diaoduService.selectById(id);
        if(diaodu !=null){
            //entity转view
            DiaoduView view = new DiaoduView();
            BeanUtils.copyProperties( diaodu , view );//把实体数据重构到view中

            //级联表
            CheliangEntity cheliang = cheliangService.selectById(diaodu.getCheliangId());
            if(cheliang != null){
                BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setCheliangId(cheliang.getId());
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
    public R save(@RequestBody DiaoduEntity diaodu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,diaodu:{}",this.getClass().getName(),diaodu.toString());
        Wrapper<DiaoduEntity> queryWrapper = new EntityWrapper<DiaoduEntity>()
            .eq("cheliang_id", diaodu.getCheliangId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiaoduEntity diaoduEntity = diaoduService.selectOne(queryWrapper);
        if(diaoduEntity==null){
            diaodu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      diaodu.set
        //  }
            diaoduService.insert(diaodu);
            return R.ok();
        }else {
            return R.error(511,"车辆已经被调度");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DiaoduEntity diaodu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,diaodu:{}",this.getClass().getName(),diaodu.toString());
        //根据字段查询是否有相同数据
        Wrapper<DiaoduEntity> queryWrapper = new EntityWrapper<DiaoduEntity>()
            .notIn("id",diaodu.getId())
            .andNew()
            .eq("cheliang_id", diaodu.getCheliangId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DiaoduEntity diaoduEntity = diaoduService.selectOne(queryWrapper);
        if(diaoduEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      diaodu.set
            //  }
            diaoduService.updateById(diaodu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"车辆已经被调度");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        diaoduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



}

