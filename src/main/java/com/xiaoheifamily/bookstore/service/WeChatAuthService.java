package com.xiaoheifamily.bookstore.service;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class WeChatAuthService {

    private final String token;

    @Autowired
    public WeChatAuthService(@Value("${wechat.auth.token}") String token) {
        this.token = token;
    }

    public boolean validateSignature(String timestamp, String nonce, String signature) {

        String[] values = {token, timestamp, nonce};
        Arrays.sort(values);

        String stringToSign = Joiner.on("")
                .join(Arrays.asList(token, timestamp, nonce).stream().sorted().toArray())
                .toLowerCase();

        String expectedSignature = Hashing.sha1().hashString(stringToSign, Charsets.UTF_8).toString();

        return expectedSignature.equals(signature);
    }
}