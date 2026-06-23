package com.dao;

import com.entity.FengkongzhuanyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FengkongzhuanyuanVO;
import com.entity.view.FengkongzhuanyuanView;


/**
 * 风控专员
 * 
 * @author 
 * @email 
 * @date 2025-03-11 11:25:57
 */
public interface FengkongzhuanyuanDao extends BaseMapper<FengkongzhuanyuanEntity> {
	
	List<FengkongzhuanyuanVO> selectListVO(@Param("ew") Wrapper<FengkongzhuanyuanEntity> wrapper);
	
	FengkongzhuanyuanVO selectVO(@Param("ew") Wrapper<FengkongzhuanyuanEntity> wrapper);
	
	List<FengkongzhuanyuanView> selectListView(@Param("ew") Wrapper<FengkongzhuanyuanEntity> wrapper);

	List<FengkongzhuanyuanView> selectListView(Pagination page,@Param("ew") Wrapper<FengkongzhuanyuanEntity> wrapper);

	
	FengkongzhuanyuanView selectView(@Param("ew") Wrapper<FengkongzhuanyuanEntity> wrapper);
	

}
