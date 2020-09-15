package com.youyuan.base64;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * 类名称：TestBase64 <br>
 * 类描述： Base64补等号测试 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/8 7:59<br>
 */
public class TestBase64 {

    public static void main(String[] args) {
        //  1：MQ== 表示一个字节，不够三个字节，所以需要后面通过 == 号补齐
        System.out.println(Base64.encode("1".getBytes()));
//        System.out.println(Base64.encode("12".getBytes()));
//        System.out.println(Base64.encode("123".getBytes()));
//        // 硅谷:中文占6个字节，6 * 8 = 48 ，刚刚好被整除，所以没有等号 UTF-8编码一个中文3个字节 GBK编码一个中文2个字节
//        System.out.println(Base64.encode("硅谷".getBytes()));
    }

}
