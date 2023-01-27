package com.cv.decoder;

import com.cv.decoder.impl.Base64Decoder;
import com.cv.decoder.impl.URLDecoder;
import com.cv.encoder.impl.XMLEscape;
import com.cv.decoder.impl.HtmlUnEscape;
import org.junit.Assert;
import org.junit.Test;

public class DecoderTest {
    @Test
    public void testBase64Decode() {
        String input = "U2ltcGxlIFBsYWluIFRleHQgdG8gYmUgQmFzZTY0IEVuY29kZWQ=";
        String expected = "Simple Plain Text to be Base64 Encoded";
        String output = new Base64Decoder().decode(input);
        Assert.assertEquals(output, expected);
    }

    @Test
    public void testXMLEncoder() {
        String input = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        String expected = "&lt;note&gt;\n" +
                "&lt;to&gt;Tove&lt;/to&gt;\n" +
                "&lt;from&gt;Jani&lt;/from&gt;\n" +
                "&lt;heading&gt;Reminder&lt;/heading&gt;\n" +
                "&lt;body&gt;Don&apos;t forget me this weekend!&lt;/body&gt;\n" +
                "&lt;/note&gt;";

        String output = new XMLEscape().encode(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testHtmlUnEscape(){
        String expected = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Page title </title> </head>\n" +
                "<body>\n" +
                "<hl> First Heading</hl> <p> First paragraph.</p> \n" +
                "<h2> Text with apostrophe -> Bhushan's tests </body>\n" +
                "</html>";
        String input = "&lt;!DOCTYPE html&gt;\n" +
                "&lt;html&gt;\n" +
                "&lt;head&gt;\n" +
                "&lt;title&gt; Page title &lt;/title&gt; &lt;/head&gt;\n" +
                "&lt;body&gt;\n" +
                "&lt;hl&gt; First Heading&lt;/hl&gt; &lt;p&gt; First paragraph.&lt;/p&gt; \n" +
                "&lt;h2&gt; Text with apostrophe -&gt; Bhushan's tests &lt;/body&gt;\n" +
                "&lt;/html&gt;";
        String output = new HtmlUnEscape().decode(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testUrlDecode() {
        String input = "https%3A%2F%2Fwww.cv-test.com%2Fphoto-gifts%2Fgift-certificates%3FstyleId%3D..%2F..%2F..%2F..%2F..%2Fjump%2Fcaptions.jsp%3Fre%3D%2F%5Csv.uy";
        String expected = "https://www.cv-test.com/photo-gifts/gift-certificates?styleId=../../../../../jump/captions.jsp?re=/\\sv.uy";
        String output = new URLDecoder().decode(input);
        Assert.assertEquals(expected, output);
    }
}