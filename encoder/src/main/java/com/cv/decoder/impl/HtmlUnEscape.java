package com.cv.decoder.impl;

import com.cv.decoder.Decoder;
import org.apache.commons.text.StringEscapeUtils;

public class HtmlUnEscape implements Decoder {
    @Override
    public String decode(String encodedText) {
        return StringEscapeUtils.unescapeHtml3(encodedText);
    }
}
