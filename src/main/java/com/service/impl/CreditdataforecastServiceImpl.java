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


import com.dao.CreditdataforecastDao;
import com.entity.CreditdataforecastEntity;
import com.service.CreditdataforecastService;
import com.entity.vo.CreditdataforecastVO;
import com.entity.view.CreditdataforecastView;

@Service("creditdataforecastService")
public class CreditdataforecastServiceImpl extends ServiceImpl<CreditdataforecastDao, CreditdataforecastEntity> implements CreditdataforecastService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CreditdataforecastEntity> page = this.selectPage(
                new Query<CreditdataforecastEntity>(params).getPage(),
                new EntityWrapper<CreditdataforecastEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CreditdataforecastEntity> wrapper) {
		  Page<CreditdataforecastView> page =new Query<CreditdataforecastView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CreditdataforecastVO> selectListVO(Wrapper<CreditdataforecastEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CreditdataforecastVO selectVO(Wrapper<CreditdataforecastEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CreditdataforecastView> selectListView(Wrapper<CreditdataforecastEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CreditdataforecastView selectView(Wrapper<CreditdataforecastEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
