package com.dao;

import com.entity.CreditdataforecastEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CreditdataforecastVO;
import com.entity.view.CreditdataforecastView;


/**
 * 信贷数据
 * 
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public interface CreditdataforecastDao extends BaseMapper<CreditdataforecastEntity> {
	
	List<CreditdataforecastVO> selectListVO(@Param("ew") Wrapper<CreditdataforecastEntity> wrapper);
	
	CreditdataforecastVO selectVO(@Param("ew") Wrapper<CreditdataforecastEntity> wrapper);
	
	List<CreditdataforecastView> selectListView(@Param("ew") Wrapper<CreditdataforecastEntity> wrapper);

	List<CreditdataforecastView> selectListView(Pagination page,@Param("ew") Wrapper<CreditdataforecastEntity> wrapper);

	
	CreditdataforecastView selectView(@Param("ew") Wrapper<CreditdataforecastEntity> wrapper);
	

}
