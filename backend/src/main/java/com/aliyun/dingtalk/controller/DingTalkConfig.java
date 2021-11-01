package com.aliyun.dingtalk.controller;

import java.util.HashMap;
import java.util.Map;

import com.aliyun.dingtalk.config.AppConfig;
import com.aliyun.dingtalk.model.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DingTalkConfig {

    @Autowired
    private AppConfig appConfig;

    /**
     * 获取钉钉配置
     * @return
     */
    @GetMapping("/config")
    public ServiceResult<Map> getDingTalkConfig() {
        Map<String, String> configMap = new HashMap<>();
        configMap.put("corpId", appConfig.getCorpId());
        return ServiceResult.getSuccessResult(configMap);
    }
}
