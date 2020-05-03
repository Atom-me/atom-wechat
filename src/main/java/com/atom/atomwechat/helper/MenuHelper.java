package com.atom.atomwechat.helper;

import com.atom.atomwechat.constant.WeChatConstant;
import com.atom.atomwechat.model.menu.Button;
import com.atom.atomwechat.model.menu.ClickButton;
import com.atom.atomwechat.model.menu.Menu;
import com.atom.atomwechat.model.menu.ViewButton;
import com.atom.atomwechat.model.resp.AccessTokenResp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * 自定义菜单
 *
 * @author Atom
 */
@Slf4j
public class MenuHelper {

    private Menu setupMenu() {
        Menu menu = new Menu();
        ClickButton clickButton = new ClickButton();
        clickButton.setName("公司地址");
        clickButton.setType("click");
        clickButton.setKey("click_001");

        ViewButton viewButton = new ViewButton();
        viewButton.setName("Java教程");
        viewButton.setType("view");
        viewButton.setUrl("https://search.bilibili.com/all?keyword=java&from_source=nav_search_new");

        ClickButton clickButton2 = new ClickButton();
        clickButton2.setName("扫描二维码");
        clickButton2.setType("scancode_push");
        clickButton2.setKey("click_002");

        ClickButton clickButton3 = new ClickButton();
        clickButton3.setName("发送位置");
        clickButton3.setType("location_select");
        clickButton3.setKey("click_003");


        ViewButton viewButton2 = new ViewButton();
        viewButton2.setName("你喜欢的👙");
        viewButton2.setType("view");
        viewButton2.setUrl("https://www.poco.cn/works/detail_id21268618");


        Button button = new Button();
        button.setName("工具箱");

        //设置子菜单,菜单布局
        button.setSubButton(Arrays.asList(clickButton2, clickButton3, viewButton2));

        menu.setButton(Arrays.asList(clickButton, viewButton, button));
        return menu;
    }

    public String create() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        AccessTokenResp accessTokenResp = restTemplate.getForObject(WeChatConstant.ACCESS_TOKEN_URL, AccessTokenResp.class, WeChatConstant.APP_ID, WeChatConstant.APP_SECRET);

        Menu menu = setupMenu();

        ObjectMapper mapper = new ObjectMapper();
        String menuJsonString = mapper.writeValueAsString(menu);
        String createMenuUrl = WeChatConstant.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessTokenResp.getAccessToken());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<String> requestEntity = new HttpEntity<>(menuJsonString, headers);
        AccessTokenResp accessTokenResp1 = restTemplate.postForObject(createMenuUrl, requestEntity, AccessTokenResp.class);
        log.info(accessTokenResp1.toString());

        return null;
    }

    public static void main(String[] args) throws JsonProcessingException {
        new MenuHelper().create();
    }

}
