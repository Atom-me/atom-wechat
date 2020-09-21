package com.atom.wechat.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Atom
 */
public final class WeChatUtil {

    private WeChatUtil() {
    }

    /**
     * 1）将token、timestamp、nonce三个参数进行字典序排序
     * 2）将三个参数字符串拼接成一个字符串进行sha1加密
     * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     */
    public static boolean checkSignature(String token, String timestamp, String nonce, String signature) {
        List<String> params = Arrays.asList(token, timestamp, nonce);
        Collections.sort(params);
        String finalParamStr = String.join("", params);
        return signature.equals(Sha1Util.encode(finalParamStr));
    }
}
