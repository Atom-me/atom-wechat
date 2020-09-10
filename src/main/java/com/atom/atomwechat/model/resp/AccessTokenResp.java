package com.atom.atomwechat.model.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * get access_token .
 *
 * @author Atom
 */
@Data
public class AccessTokenResp implements Serializable {

    /**
     * 建议公众号开发者使用中控服务器统一获取和刷新access_token，其他业务逻辑服务器所使用的access_token均来自于该中控服务器，
     * 不应该各自去刷新，否则容易造成冲突，导致access_token覆盖而影响业务
     * <p>
     * 获取到的接口访问凭证.
     * access_token的存储至少要保留512个字符空间
     */
    @JsonProperty(value = "access_token")
    private String accessToken;
    /**
     * 2、目前access_token的有效期通过返回的expire_in来传达，目前是7200秒之内的值。
     * 中控服务器需要根据这个有效时间提前去刷新新access_token。
     * 在刷新过程中，中控服务器可对外继续输出的老access_token，此时公众平台后台会保证在5分钟内，新老access_token都可用，这保证了第三方业务的平滑过渡
     * <p>
     * 凭证有效时间，单位：秒. access_token的有效期目前为2个小时（7200秒）
     */
    @JsonProperty(value = "expires_in")
    private Long expiresIn;

    @JsonProperty(value = "errcode")
    private Integer errCode;

    @JsonProperty(value = "errmsg")
    private String errMsg;
}
