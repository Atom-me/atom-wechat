package com.atom.wechat.model.shorturl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 微信长链接转短链接请求对象
 *
 * @author Atom
 */
@Data
@Builder
public class ShortUrlReq {
    /**
     * 此处填long2short，代表长链接转短链接
     */
    private String action;
    /**
     * 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
     */
    @JsonProperty(value = "long_url")
    private String longUrl;
}
