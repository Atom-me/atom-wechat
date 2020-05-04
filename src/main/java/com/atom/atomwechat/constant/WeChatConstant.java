package com.atom.atomwechat.constant;

/**
 * @author Atom
 */
public interface WeChatConstant {

    /**
     * Token可由开发者可以任意填写，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）
     */
    String TOKEN = "qwdfghjk34567hgfd";

    /**
     * 微信公众号APPID
     */
    String APP_ID = "wxe69d5134ef7da536";

    /**
     * 微信公众号 APPSECRET
     */
    String APP_SECRET = "06db111e09c523c4a74ccb58576e2ee1";

    /**
     * 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid）
     */
    String SNSAPI_BASE = "snsapi_base";

    /**
     * 应用授权作用域，snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且， 即使在未关注的情况下，只要用户授权，也能获取其信息 ）
     */
    String SNSAPI_USERINFO = "snsapi_userinfo";

    /**
     * 微信网页授权回调地址的域名，在微信公众号后台配置的时候不要添加http:
     */
    String BASE_DOMAIN_URL = "http://atom.vipgz4.idcfengye.com";

    /**
     * 公众平台的API调用所需的access_token
     */
    String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={1}&secret={2}";

    /**
     * 微信公众号创建自定义菜单
     */
    String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 获取帐号的关注者列表
     */
    String FANS_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token={1}&next_openid={2}";

    /**
     * 获取用户基本信息（包括UnionID机制）
     */
    String FANS_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={1}&openid={2}&lang=zh_CN";

    /**
     * 长链接转短链接
     */
    String SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";

    /**
     * 获取公众号的黑名单列表
     */
    String GET_BLACK_LIST_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN";

    /**
     * 批量拉黑用户
     */
    String BATCH_BLACK_LIST = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN";

    /**
     * 取消拉黑用户
     */
    String BATCH_UN_BLACK_LIST = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN";

    /**
     * 微信网页授权
     */
    String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

    /**
     * 通过code换取网页授权access_token
     * 这里通过code换取的是一个特殊的网页授权access_token,与基础支持中的access_token（该access_token用于调用其他接口）不同
     */
    String OAUTH2_ACCESS_TOKEN_BASE_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * ACCESS_TOKEN:网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    String OAUTH2_USER_INFO_BASE_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
}
