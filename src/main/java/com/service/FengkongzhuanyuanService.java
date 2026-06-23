package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FengkongzhuanyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FengkongzhuanyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FengkongzhuanyuanView;


/**
 * 风控专员
 *
 * @author 
 * @email 
 * @date 2025-03-11 11:25:57
 */
public interface FengkongzhuanyuanService extends IService<FengkongzhuanyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FengkongzhuanyuanVO> selectListVO(Wrapper<FengkongzhuanyuanEntity> wrapper);
   	
   	FengkongzhuanyuanVO selectVO(@Param("ew") Wrapper<FengkongzhuanyuanEntity> wrapper);
   	
   	List<FengkongzhuanyuanView> selectListView(Wrapper<FengkongzhuanyuanEntity> wrapper);
   	
   	FengkongzhuanyuanView selectView(@Param("ew") Wrapper<FengkongzhuanyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FengkongzhuanyuanEntity> wrapper);

   	

}

