package com.example.features.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @Author: lyh
 * @Date: 2021/05/21  16:48
 * @Description:
 */
public class TestBase64 {
    public static void main(String[] args) {
        try {
            //使用基本解码
            String base64encodedString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串 (基本) :" + base64encodedString);
            //解码
            byte[] base64DecodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println("原始字符串:" + new String(base64DecodedBytes, "utf-8"));

            //使用 URL 和文件名
            base64encodedString = Base64.getUrlEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            System.out.println("Base64 编码字符串(URL):" + base64encodedString);
            //解码
            base64DecodedBytes = Base64.getUrlDecoder().decode(base64encodedString.getBytes("utf-8"));
            System.out.println("Base64 解码字符串(URL):" + new String(base64DecodedBytes, "utf-8"));

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }

            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 编码字符串(MIME):" + mimeEncodedString);
            //解码
            mimeBytes = Base64.getMimeDecoder().decode(mimeEncodedString);
            System.out.println("Base64 解码字符串(MIME):" + new String(mimeBytes, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
