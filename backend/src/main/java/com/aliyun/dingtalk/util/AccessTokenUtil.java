package com.aliyun.dingtalk.util;

import com.aliyun.dingtalk.constant.UrlConstant;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;

import java.util.Objects;


/**
 * 获取access_token工具类
 */
@Slf4j
public class AccessTokenUtil {

    /**
     * 在使用accessToken时，请注意：
     * accessToken的有效期为7200秒（2小时），有效期内重复获取会返回相同结果并自动续期，过期后获取会返回新的accessToken。
     * 开发者需要缓存accessToken，用于后续接口的调用。因为每个应用的accessToken是彼此独立的，所以进行缓存时需要区分应用来进行存储。
     * 不能频繁调用接口，否则会受到频率拦截。
     *
     * @param appKey
     * @param appSecret
     * @return
     */
    public static String getAccessToken(String appKey, String appSecret) {

        DefaultDingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_ACCESS_TOKEN_URL);
        OapiGettokenRequest request = new OapiGettokenRequest();

        request.setAppkey(appKey);
        request.setAppsecret(appSecret);
        request.setHttpMethod(HttpMethod.GET.name());

        try {
            OapiGettokenResponse response = client.execute(request);
            if (!Objects.isNull(response)) {
                return response.getAccessToken();
            } else {
                log.error("获取accessToken响应为空");
            }

        } catch (ApiException e) {
            // 需要自己处理异常
            e.printStackTrace();
        }

        return null;
    }
}
