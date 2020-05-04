package com.atom.atomwechat.controller;

import com.atom.atomwechat.model.oauth.Oauth2AccessTokenResp;
import com.atom.atomwechat.model.oauth.WeChatUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.atom.atomwechat.constant.WeChatConstant.*;

/**
 * @author Atom
 */
@Controller
@Slf4j
public class OauthController {

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
     * <p>
     * SpringMVC跳转外部项目方式
     * 1. response.sendRedirect(url);
     * 2. return new ModelAndView(new RedirectView(url));
     * 3. return "redirect:" + url;
     */
    @GetMapping("authorize")
    public String authorize() {

        /**
         * 授权后重定向的回调链接地址， 请使用 urlEncode 对链接进行处理
         * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
         */
        String callbackUrl = BASE_DOMAIN_URL + "/wechat/callback";

        String url = StringUtils.replaceEach(AUTHORIZE_URL,
                new String[]{"APPID", "REDIRECT_URI", "SCOPE", "STATE"},
                new String[]{APP_ID, callbackUrl, SNSAPI_BASE, "anyStringYouWant"});

        return "redirect:" + url;
    }


    /**
     * 这个接口地址是由我们指定，由腾讯服务器回调
     * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
     *
     * @param request
     */
    @GetMapping(value = "/callback")
    public String callback(HttpServletRequest request, Model model) {
        String code = request.getParameter("code");
        String state = request.getParameter("state");

        // 得到code之后，通过code换取网页授权access_token(请求腾讯认证服务器)
        String oAuthTokenRealUrl = StringUtils.replaceEach(OAUTH2_ACCESS_TOKEN_BASE_URL,
                new String[]{"APPID", "SECRET", "CODE"},
                new String[]{APP_ID, APP_SECRET, code});

        ResponseEntity<Oauth2AccessTokenResp> oauth2AccessTokenResponseEntity = restTemplate.postForEntity(oAuthTokenRealUrl, null, Oauth2AccessTokenResp.class);
        Oauth2AccessTokenResp oauth2AccessTokenResp = oauth2AccessTokenResponseEntity.getBody();
        log.info(oauth2AccessTokenResp.toString());

        //根据openid 和 access_token 拉取用户信息(需scope为 snsapi_userinfo)（请求腾讯资源服务器）
        String userInfoUrl = StringUtils.replaceEach(OAUTH2_USER_INFO_BASE_URL,
                new String[]{"ACCESS_TOKEN", "OPENID"},
                new String[]{"oauth2AccessTokenResp.getAccessToken()", oauth2AccessTokenResp.getOpenId()});

        WeChatUserInfo userInfo = restTemplate.getForObject(userInfoUrl, WeChatUserInfo.class);
        log.info(userInfo.toString());
/*

        ResponseEntity<WeChatUserInfo> forEntity = restTemplate.getForEntity(userInfoUrl, WeChatUserInfo.class);
*/

        model.addAttribute("userInfo", userInfo);
        return "userInfo";
    }
}
