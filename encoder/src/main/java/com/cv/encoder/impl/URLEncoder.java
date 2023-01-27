package com.cv.encoder.impl;

import com.cv.encoder.Encoder;

import java.nio.charset.StandardCharsets;

public class URLEncoder implements Encoder {
    @Override
    public String encode(String plainText) {
        return java.net.URLEncoder.encode(plainText, StandardCharsets.UTF_8);
    }
}
