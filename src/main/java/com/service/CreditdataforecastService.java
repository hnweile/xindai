package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CreditdataforecastEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CreditdataforecastVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CreditdataforecastView;


/**
 * 信贷数据
 *
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public interface CreditdataforecastService extends IService<CreditdataforecastEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CreditdataforecastVO> selectListVO(Wrapper<CreditdataforecastEntity> wrapper);
   	
   	CreditdataforecastVO selectVO(@Param("ew") Wrapper<CreditdataforecastEntity> wrapper);
   	
   	List<CreditdataforecastView> selectListView(Wrapper<CreditdataforecastEntity> wrapper);
   	
   	CreditdataforecastView selectView(@Param("ew") Wrapper<CreditdataforecastEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CreditdataforecastEntity> wrapper);

   	

}

