package com.atom.atomwechat.model.resp;

import lombok.Data;

/**
 * @author Atom
 */
@Data
public class ShortUrlResp {
    private Integer errcode;
    private String errmsg;
    /**
     * 短链接
     */
    private String short_url;


}
