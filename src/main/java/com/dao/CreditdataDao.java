package com.dao;

import com.entity.CreditdataEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CreditdataVO;
import com.entity.view.CreditdataView;


/**
 * 信贷数据
 * 
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public interface CreditdataDao extends BaseMapper<CreditdataEntity> {
	
	List<CreditdataVO> selectListVO(@Param("ew") Wrapper<CreditdataEntity> wrapper);
	
	CreditdataVO selectVO(@Param("ew") Wrapper<CreditdataEntity> wrapper);
	
	List<CreditdataView> selectListView(@Param("ew") Wrapper<CreditdataEntity> wrapper);

	List<CreditdataView> selectListView(Pagination page,@Param("ew") Wrapper<CreditdataEntity> wrapper);

	
	CreditdataView selectView(@Param("ew") Wrapper<CreditdataEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CreditdataEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CreditdataEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CreditdataEntity> wrapper);

    List<Map<String, Object>> ageSectionStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CreditdataEntity> wrapper);


}
