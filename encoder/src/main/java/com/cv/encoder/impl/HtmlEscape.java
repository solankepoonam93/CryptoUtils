package com.cv.encoder.impl;

import com.cv.encoder.Encoder;
import org.apache.commons.text.StringEscapeUtils;

public class HtmlEscape implements Encoder {
    @Override
    public String encode(String plainText) {
        return StringEscapeUtils.escapeHtml4(plainText);
    }
}
