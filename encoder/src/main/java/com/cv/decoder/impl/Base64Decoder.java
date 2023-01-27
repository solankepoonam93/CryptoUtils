package com.cv.decoder.impl;

import com.cv.decoder.Decoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Decoder implements Decoder {
    @Override
    public String decode(String encodedText) {
        return new String(Base64.getDecoder().decode(encodedText), StandardCharsets.UTF_8);
    }
}
