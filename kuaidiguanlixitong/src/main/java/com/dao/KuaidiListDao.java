package com.dao;

import com.entity.KuaidiListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KuaidiListView;

/**
 * 快递详情 Dao 接口
 *
 * @author 
 * @since 2021-04-16
 */
public interface KuaidiListDao extends BaseMapper<KuaidiListEntity> {

   List<KuaidiListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
