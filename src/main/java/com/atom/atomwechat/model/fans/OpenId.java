package com.atom.atomwechat.model.fans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Atom
 */
@Data
public class OpenId {
    /**
     * OPENID的列表
     */
    @JsonProperty(value = "openid")
    private List<String> openId;
}
