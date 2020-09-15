package com.youyuan.ascii;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/9/4 6:35
 */
public class AsciiDemo1 {

    public static void main(String[] args) {
        //把字符串转为ascii码
        String a = "AaZ";
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int asciiCode = chars[i];
            System.out.println(asciiCode);
        }
    }

}
