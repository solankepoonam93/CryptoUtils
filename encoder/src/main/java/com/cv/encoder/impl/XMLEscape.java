package com.cv.encoder.impl;

import com.cv.decoder.Decoder;
import com.cv.encoder.Encoder;
import org.apache.commons.text.StringEscapeUtils;


public class XMLEscape implements Encoder {
    @Override
    public String encode(String encodedText) {
        return StringEscapeUtils.escapeXml10(encodedText);
    }
}