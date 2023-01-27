package com.cv.decoder.impl;

import com.cv.decoder.Decoder;
import org.apache.commons.text.StringEscapeUtils;


public class XMLUnEscape implements Decoder {

    @Override
    public String decode(String plainText) {
        return StringEscapeUtils.unescapeXml(plainText);
    }
}