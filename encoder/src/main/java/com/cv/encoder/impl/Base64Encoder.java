package com.cv.encoder.impl;

import com.cv.encoder.Encoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Encoder implements Encoder {
    @Override
    public String encode(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }
}


