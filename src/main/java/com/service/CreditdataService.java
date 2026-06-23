package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CreditdataEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CreditdataVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CreditdataView;


/**
 * 信贷数据
 *
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public interface CreditdataService extends IService<CreditdataEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CreditdataVO> selectListVO(Wrapper<CreditdataEntity> wrapper);
   	
   	CreditdataVO selectVO(@Param("ew") Wrapper<CreditdataEntity> wrapper);
   	
   	List<CreditdataView> selectListView(Wrapper<CreditdataEntity> wrapper);
   	
   	CreditdataView selectView(@Param("ew") Wrapper<CreditdataEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CreditdataEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CreditdataEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CreditdataEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CreditdataEntity> wrapper);

    List<Map<String, Object>> ageSectionStat(Map<String, Object> params,Wrapper<CreditdataEntity> wrapper);


}

