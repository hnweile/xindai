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


import com.dao.CreditdataDao;
import com.entity.CreditdataEntity;
import com.service.CreditdataService;
import com.entity.vo.CreditdataVO;
import com.entity.view.CreditdataView;

@Service("creditdataService")
public class CreditdataServiceImpl extends ServiceImpl<CreditdataDao, CreditdataEntity> implements CreditdataService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CreditdataEntity> page = this.selectPage(
                new Query<CreditdataEntity>(params).getPage(),
                new EntityWrapper<CreditdataEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CreditdataEntity> wrapper) {
		  Page<CreditdataView> page =new Query<CreditdataView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CreditdataVO> selectListVO(Wrapper<CreditdataEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CreditdataVO selectVO(Wrapper<CreditdataEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CreditdataView> selectListView(Wrapper<CreditdataEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CreditdataView selectView(Wrapper<CreditdataEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CreditdataEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CreditdataEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CreditdataEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> ageSectionStat(Map<String, Object> params, Wrapper<CreditdataEntity> wrapper) {
        return baseMapper.ageSectionStat(params, wrapper);
    }



}
