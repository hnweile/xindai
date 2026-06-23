package com.entity.view;

import com.entity.XinyongpingguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 信用评估
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
@TableName("xinyongpinggu")
public class XinyongpingguView  extends XinyongpingguEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinyongpingguView(){
	}
 
 	public XinyongpingguView(XinyongpingguEntity xinyongpingguEntity){
 	try {
			BeanUtils.copyProperties(this, xinyongpingguEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
