package com.entity.view;

import com.entity.CreditdataforecastEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 信贷数据
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
@TableName("creditdataforecast")
public class CreditdataforecastView  extends CreditdataforecastEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CreditdataforecastView(){
	}
 
 	public CreditdataforecastView(CreditdataforecastEntity creditdataforecastEntity){
 	try {
			BeanUtils.copyProperties(this, creditdataforecastEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
