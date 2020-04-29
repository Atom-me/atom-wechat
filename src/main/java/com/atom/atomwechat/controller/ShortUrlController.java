package com.atom.atomwechat.controller;

import com.atom.atomwechat.constant.WeChatConstant;
import com.atom.atomwechat.model.req.shorturl.ShortUrlReq;
import com.atom.atomwechat.model.resp.AccessTokenResp;
import com.atom.atomwechat.model.resp.ShortUrlResp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author Atom
 */
@RestController
public class ShortUrlController {

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/shortUrl")
    public ResponseEntity<ShortUrlResp> shortUrl(@RequestParam("longUrl") String longUrl) throws IOException {

        AccessTokenResp accessTokenResp = restTemplate.getForObject(WeChatConstant.ACCESS_TOKEN_URL, AccessTokenResp.class, WeChatConstant.APPID, WeChatConstant.APPSECRET);

        String url = WeChatConstant.SHORT_URL.replace("ACCESS_TOKEN", accessTokenResp.getAccess_token());
        ShortUrlReq shortUrlReq = ShortUrlReq.builder()
                .long_url(longUrl)
                .action("long2short")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String shortUrlReqJsonString = mapper.writeValueAsString(shortUrlReq);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(shortUrlReqJsonString, headers);
        ShortUrlResp shortUrlResp = restTemplate.postForObject(url, requestEntity, ShortUrlResp.class);
        return ResponseEntity.ok(shortUrlResp);
    }
}
