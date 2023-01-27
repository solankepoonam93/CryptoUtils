package com.cv.decoder.impl;

import com.cv.decoder.Decoder;
import com.cv.encoder.Encoder;

import java.nio.charset.StandardCharsets;

public class URLDecoder implements Decoder {
    @Override
    public String decode(String plainText) {
        return java.net.URLDecoder.decode(plainText, StandardCharsets.UTF_8);
    }
}
