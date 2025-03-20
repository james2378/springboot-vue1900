package com.dao;

import com.entity.DiaoduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DiaoduView;

/**
 * 车辆调度 Dao 接口
 *
 * @author 
 * @since 2021-04-16
 */
public interface DiaoduDao extends BaseMapper<DiaoduEntity> {

   List<DiaoduView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
