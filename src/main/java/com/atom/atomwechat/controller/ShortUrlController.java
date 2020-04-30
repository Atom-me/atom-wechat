package com.atom.atomwechat.controller;

import com.atom.atomwechat.helper.AccessTokenHelper;
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

import static com.atom.atomwechat.constant.WeChatConstant.SHORT_URL;

/**
 * @author Atom
 */
@RestController
public class ShortUrlController {

    @Resource
    private AccessTokenHelper accessTokenHelper;

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/shortUrl")
    public ResponseEntity<ShortUrlResp> shortUrl(@RequestParam("longUrl") String longUrl) throws IOException {

        //get access_token
        AccessTokenResp accessTokenResp = accessTokenHelper.accessToken();
        String url = SHORT_URL.replace("ACCESS_TOKEN", accessTokenResp.getAccessToken());
        ShortUrlReq shortUrlReq = ShortUrlReq.builder()
                .longUrl(longUrl)
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
