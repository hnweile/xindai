package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.FengkongzhuanyuanDao;
import com.entity.FengkongzhuanyuanEntity;
import com.service.FengkongzhuanyuanService;
import com.entity.vo.FengkongzhuanyuanVO;
import com.entity.view.FengkongzhuanyuanView;

@Service("fengkongzhuanyuanService")
public class FengkongzhuanyuanServiceImpl extends ServiceImpl<FengkongzhuanyuanDao, FengkongzhuanyuanEntity> implements FengkongzhuanyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FengkongzhuanyuanEntity> page = this.selectPage(
                new Query<FengkongzhuanyuanEntity>(params).getPage(),
                new EntityWrapper<FengkongzhuanyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FengkongzhuanyuanEntity> wrapper) {
		  Page<FengkongzhuanyuanView> page =new Query<FengkongzhuanyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FengkongzhuanyuanVO> selectListVO(Wrapper<FengkongzhuanyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FengkongzhuanyuanVO selectVO(Wrapper<FengkongzhuanyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FengkongzhuanyuanView> selectListView(Wrapper<FengkongzhuanyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FengkongzhuanyuanView selectView(Wrapper<FengkongzhuanyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
