package com.xiaoheifamily.bookstore.controller;

import com.xiaoheifamily.bookstore.service.WeChatAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wechat")
public class WeChatController {

    private final WeChatAuthService weChatAuthService;

    @Autowired
    public WeChatController(WeChatAuthService weChatAuthService) {
        this.weChatAuthService = weChatAuthService;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    @ResponseBody
    public String authenticate(String timestamp, String nonce, String signature, String echostr) {

        if (weChatAuthService.validateSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        throw new RuntimeException("signature validation error.");
    }
}