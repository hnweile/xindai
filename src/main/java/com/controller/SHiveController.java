package com.controller;

import com.annotation.IgnoreAuth;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import javax.servlet.http.HttpServletRequest;

import com.service.SHiveService;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.service.CreditdataService;
import com.entity.CreditdataEntity;
import com.utils.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shive")
public class SHiveController {

    @Autowired
    private SHiveService sHiveService;

                                                                                                                                                                                                                                                                                        @Autowired
                private YonghuService yonghuService;
                                                                                                                                                                                                                        @Autowired
                private CreditdataService creditdataService;
                                                    private String dataBase = "springboot3913hmjw";

    @IgnoreAuth
    @RequestMapping("analyze")
    public R analyze(HttpServletRequest request) throws Exception {
        sHiveService.createDatabase(dataBase);
        value(request);
        valueMul(request);
        group(request);
        return R.ok();
    }

    /**
    * （按值统计）
    */
    private void value(HttpServletRequest request) throws Exception {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                                    sHiveService.init(dataBase, "creditdata", creditdataService.selectList(new EntityWrapper<CreditdataEntity>()));
                                                    for (int i = 0; i < ",number,number,number".split(",").length; i++) {
                        String xColumn = ",number,number,number".split(",")[i];
                        if ("".equals(xColumn)) {
                            continue;
                        }
                        String[] timeTypes = ",无,无,无".trim().split(",");
                        String[] yColumns = ",annualincome,totalassets,totalliabilities".trim().split(",");
                        String timeType = (i < timeTypes.length && timeTypes[i] != "" && !timeTypes[i].equals("无")) ? timeTypes[i] : "timeType";
                        String where = "";
                                                                        sHiveService.value(dataBase, "creditdata", xColumn, timeType, where, yColumns[i]);
                    }
                                                                                }

    private String Where(String where_, String sql) {
        if ("" == where_) {
            where_ += " where ";
        } else {
            where_ += " and ";
        }
        return where_ += sql;
    }

    /**
     * （按值统计(多)）
     */
    private void valueMul(HttpServletRequest request) throws Exception {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }


    /**
 * （按类统计）
 */
    private void group(HttpServletRequest request) throws Exception {
                                                                                                                                                                                                                        sHiveService.init(dataBase, "yonghu", yonghuService.selectList(new EntityWrapper<YonghuEntity>()));
                            sHiveService.group(dataBase, "yonghu", "xingbie", "");
                                                                                                                                                                                                                                                                                                                                                                                                                    sHiveService.init(dataBase, "creditdata", creditdataService.selectList(new EntityWrapper<CreditdataEntity>()));
                            sHiveService.group(dataBase, "creditdata", "gender", "");
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }

}
