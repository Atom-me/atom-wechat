package com.atom.atomwechat.model.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 长链接转短链接腾讯返回对象
 *
 * @author Atom
 */
@Data
public class ShortUrlResp {
    @JsonProperty(value = "errcode")
    private Integer errCode;
    @JsonProperty(value = "errmsg")
    private String errMsg;
    /**
     * 短链接
     */
    @JsonProperty(value = "short_url")
    private String shortUrl;


}
