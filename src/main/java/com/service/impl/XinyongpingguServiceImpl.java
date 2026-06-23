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


import com.dao.XinyongpingguDao;
import com.entity.XinyongpingguEntity;
import com.service.XinyongpingguService;
import com.entity.vo.XinyongpingguVO;
import com.entity.view.XinyongpingguView;

@Service("xinyongpingguService")
public class XinyongpingguServiceImpl extends ServiceImpl<XinyongpingguDao, XinyongpingguEntity> implements XinyongpingguService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinyongpingguEntity> page = this.selectPage(
                new Query<XinyongpingguEntity>(params).getPage(),
                new EntityWrapper<XinyongpingguEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinyongpingguEntity> wrapper) {
		  Page<XinyongpingguView> page =new Query<XinyongpingguView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XinyongpingguVO> selectListVO(Wrapper<XinyongpingguEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinyongpingguVO selectVO(Wrapper<XinyongpingguEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinyongpingguView> selectListView(Wrapper<XinyongpingguEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinyongpingguView selectView(Wrapper<XinyongpingguEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
