package com.atom.atomwechat.model.fans;

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
    private List<String> openid;
}
