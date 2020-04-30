package com.atom.atomwechat.controller;

import com.atom.atomwechat.model.oauth.Oauth2AccessTokenResponse;
import com.atom.atomwechat.model.oauth.WeChatUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.atom.atomwechat.constant.WeChatConstant.*;

/**
 * @author Atom
 */
@Controller
@Slf4j
public class OAuthController {

    @Resource
    private RestTemplate restTemplate;


    //1 第一步：用户同意授权，获取code
    //2 第二步：通过code换取网页授权access_token
    //3 第三步：刷新access_token（如果需要）
    //4 第四步：拉取用户信息(需scope为 snsapi_userinfo)
    //5 附：检验授权凭证（access_token）是否有效


    /**
     * 引导关注者打开如下页面：
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("oauth")
    public void oauth(HttpServletResponse response) throws IOException {

        /**
         * 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
         * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
         */
        String callbackUrl = BASE_DOMAIN_URL + "/wechat/callback";

        String url = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" + APP_ID +
                "&redirect_uri=" + callbackUrl +
                "&response_type=code" +
                "&scope=" + SNSAPI_USERINFO +
                "&state=" + "anyStringYouWant" +
                "#wechat_redirect";
        response.sendRedirect(url);
    }


    /**
     * 这个接口地址是由我们指定，由腾讯服务器回调
     * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
     *
     * @param request
     */
    @RequestMapping(value = "/callback")
    public String callback(HttpServletRequest request, Model model) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        // 得到code之后，通过code换取网页授权access_token(请求腾讯认证服务器)
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=" + APP_ID +
                "&secret=" + APP_SECRET +
                "&code=" + code +
                "&grant_type=authorization_code";
        ResponseEntity<Oauth2AccessTokenResponse> oauth2AccessTokenResponseEntity = restTemplate.postForEntity(url, null, Oauth2AccessTokenResponse.class);
        Oauth2AccessTokenResponse oauth2AccessTokenResponse = oauth2AccessTokenResponseEntity.getBody();
        log.info(oauth2AccessTokenResponse.toString());

        //根据openid 和 access_token 拉取用户信息(需scope为 snsapi_userinfo)（请求腾讯资源服务器）
        //http：GET（请使用https协议） https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN

        String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" + oauth2AccessTokenResponse.getAccessToken() +
                "&openid=" + oauth2AccessTokenResponse.getOpenId() +
                "&lang=zh_CN";
        WeChatUserInfo userInfo = restTemplate.getForObject(userInfoUrl, WeChatUserInfo.class);
        log.info(userInfo.toString());
        model.addAttribute("userInfo", userInfo);
        return "userInfo";
    }
}
