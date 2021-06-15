package com.aliyun.dingtalk.enums;

/**
 * 如果使用授权码换token，传authorization_code。
 * 如果使用刷新token换用户token，传refresh_token。
 */
public enum GrantTypeEnum {

    AUTHORIZATION_CODE("authorization_code"),

    REFRESH_TOKEN("refresh_token");


    private String name;

    GrantTypeEnum(String name) {

        this.name = name;
    }

    public String getName() {
        return this.name;
    }


}
