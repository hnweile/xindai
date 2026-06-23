package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinyongpingguEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinyongpingguVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinyongpingguView;


/**
 * 信用评估
 *
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public interface XinyongpingguService extends IService<XinyongpingguEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinyongpingguVO> selectListVO(Wrapper<XinyongpingguEntity> wrapper);
   	
   	XinyongpingguVO selectVO(@Param("ew") Wrapper<XinyongpingguEntity> wrapper);
   	
   	List<XinyongpingguView> selectListView(Wrapper<XinyongpingguEntity> wrapper);
   	
   	XinyongpingguView selectView(@Param("ew") Wrapper<XinyongpingguEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinyongpingguEntity> wrapper);

   	

}

