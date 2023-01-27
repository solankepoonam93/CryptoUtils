package com.cv.encoder;

import com.cv.encoder.impl.HtmlEscape;
import com.cv.encoder.impl.Base64Encoder;
import com.cv.encoder.impl.URLEncoder;
import com.cv.decoder.impl.XMLUnEscape;
import org.junit.Assert;
import org.junit.Test;


public class EncoderTest {
    @Test
    public void testBase64Encode() {
        String input = "Simple Plain Text to be Base64 Encoded";
        String expected = "U2ltcGxlIFBsYWluIFRleHQgdG8gYmUgQmFzZTY0IEVuY29kZWQ=";
        String output = new Base64Encoder().encode(input);
        Assert.assertEquals(output, expected);
    }

    @Test
    public void testXMLEncoder() {
        String input = "&lt;note&gt;\n" +
                "&lt;to&gt;Tove&lt;/to&gt;\n" +
                "&lt;from&gt;Jani&lt;/from&gt;\n" +
                "&lt;heading&gt;Reminder&lt;/heading&gt;\n" +
                "&lt;body&gt;Don&apos;t forget me this weekend!&lt;/body&gt;\n" +
                "&lt;/note&gt;";

        String expected = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        String output = new XMLUnEscape().decode(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testHtmlUnEscape(){
        String input = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Page title </title> </head>\n" +
                "<body>\n" +
                "<hl> First Heading</hl> <p> First paragraph.</p> \n" +
                "<h2> Text with apostrophe -> Bhushan's tests </body>\n" +
                "</html>";
        String expected = "&lt;!DOCTYPE html&gt;\n" +
                "&lt;html&gt;\n" +
                "&lt;head&gt;\n" +
                "&lt;title&gt; Page title &lt;/title&gt; &lt;/head&gt;\n" +
                "&lt;body&gt;\n" +
                "&lt;hl&gt; First Heading&lt;/hl&gt; &lt;p&gt; First paragraph.&lt;/p&gt; \n" +
                "&lt;h2&gt; Text with apostrophe -&gt; Bhushan's tests &lt;/body&gt;\n" +
                "&lt;/html&gt;";
        String output = new HtmlEscape().encode(input);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testUrlEncode() {
        String input = "https://www.cv-test.com/photo-gifts/gift-certificates?styleId=../../../../../jump/captions.jsp?re=/\\sv.uy";
        String expected = "https%3A%2F%2Fwww.cv-test.com%2Fphoto-gifts%2Fgift-certificates%3FstyleId%3D..%2F..%2F..%2F..%2F..%2Fjump%2Fcaptions.jsp%3Fre%3D%2F%5Csv.uy";
        String output = new URLEncoder().encode(input);
        Assert.assertEquals(expected, output);
    }
}
