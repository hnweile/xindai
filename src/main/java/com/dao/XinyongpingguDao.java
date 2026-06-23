package com.dao;

import com.entity.XinyongpingguEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinyongpingguVO;
import com.entity.view.XinyongpingguView;


/**
 * 信用评估
 * 
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public interface XinyongpingguDao extends BaseMapper<XinyongpingguEntity> {
	
	List<XinyongpingguVO> selectListVO(@Param("ew") Wrapper<XinyongpingguEntity> wrapper);
	
	XinyongpingguVO selectVO(@Param("ew") Wrapper<XinyongpingguEntity> wrapper);
	
	List<XinyongpingguView> selectListView(@Param("ew") Wrapper<XinyongpingguEntity> wrapper);

	List<XinyongpingguView> selectListView(Pagination page,@Param("ew") Wrapper<XinyongpingguEntity> wrapper);

	
	XinyongpingguView selectView(@Param("ew") Wrapper<XinyongpingguEntity> wrapper);
	

}
