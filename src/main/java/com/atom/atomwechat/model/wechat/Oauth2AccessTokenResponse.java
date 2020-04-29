package com.atom.atomwechat.model.wechat;

import lombok.Data;

/**
 * @author Atom
 */
@Data
public class Oauth2AccessTokenResponse {

    /**
     * {"access_token":"32_c7MItPjyfyjpe3zvAg1Sqvkaye-SZCdtXNfg_KqvmyLgUIApapxOB2NVwRRK_Q3vUFXRwqO-iNb-1E8sNG7CbnTHByiBGBEXTq_VEkcZD3A",
     * "expires_in":7200,
     * "refresh_token":"32_3PajF258AXORA8AwJoOScNBObaEP8vdmXe0eFRJUFHpP8Q9byxQeQ-NRLeXGMUPnKZrgxblfc1e2f72aSQPA_859R4A2I1vd9PVKJ4F-BgY",
     * "openid":"oSu9iw5mdd3btzDXXZwYRViaYttI",
     * "scope":"snsapi_userinfo"}
     */

    /**
     * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    private String access_token;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    private Long expires_in;
    /**
     * 用户刷新access_token
     */
    private String refresh_token;
    /**
     * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
     */
    private String openid;
    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    private String scope;

}
