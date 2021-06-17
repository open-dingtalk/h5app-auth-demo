package com.aliyun.dingtalk.controller;

import com.aliyun.dingtalk.service.DingTalkUserService;
import com.aliyun.dingtalk.model.RpcServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 钉钉h5企业内部应用DEMO, 实现了根据用户授权码获取用户信息功能
 */
@RestController
public class DingTalkUserController {

    @Autowired
    private DingTalkUserService dingTalkUserService;

    /**
     * 欢迎页面, 检查后端服务是否启动
     *
     * @return
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 根据免登授权码, 获取登录用户身份
     *
     * @param authCode 免登授权码
     * @return
     */
    @GetMapping("/login")
    public RpcServiceResult login(@RequestParam(value = "authCode") String authCode) {

        return RpcServiceResult.getSuccessResult(dingTalkUserService.getUserInfo(authCode));

    }
}
