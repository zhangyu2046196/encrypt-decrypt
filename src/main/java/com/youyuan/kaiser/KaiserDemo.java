package com.youyuan.kaiser;

/**
 * 类名称：KaiserDemo <br>
 * 类描述： 凯撒加密 <br>
 * <p>
 * 凯撒加密是古典密码学中的移位法
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/4 6:45<br>
 */
public class KaiserDemo {

    public static void main(String[] args) {
        //原文
        String resource = "Hello World";
        System.out.println("原文：" + resource);
        //定义key也就是移位步长，此处定义向右移动3位
        int key = 3;
        String target = encrypt(resource, key);
        System.out.println("密文：" + target);

        String str = decrypt(target, key);
        System.out.println("明文：" + str);
    }

    /**
     * 方法名: encrypt <br>
     * 方法描述: 凯撒加密 <br>
     *
     * @param resource 明文
     * @param key      秘钥 代表移动几位
     * @return {@link String 返回密文 }
     * @date 创建时间: 2020/9/4 7:10 <br>
     * @author zhangyu
     */
    public static String encrypt(String resource, int key) {
        //原文转为字符数组
        char[] chars = resource.toCharArray();
        //定义StringBuilder用于接收加密后的密文
        StringBuilder sb = new StringBuilder();
        //循环遍历字符数组
        for (char aChar : chars) {
            int a = aChar;
            //向右移动指定位数
            a += key;
            char newA = (char) a;
            sb.append(newA);
        }
        return sb.toString();
    }

    /**
     * 方法名: decrypt <br>
     * 方法描述: 凯撒解密 <br>
     *
     * @param target 密文
     * @param key    秘钥 代表移动位数
     * @return {@link String 返回解密的字符串 }
     * @date 创建时间: 2020/9/4 7:14 <br>
     * @author zhangyu
     */
    public static String decrypt(String target, int key) {
        //密文数组
        char[] chars = target.toCharArray();
        //定义StringBuilder用于接收解密后的明文
        StringBuilder sb = new StringBuilder();
        //循环遍历数组
        for (char aChar : chars) {
            int a = aChar;
            a -= key;
            char newA = (char) a;
            sb.append(newA);
        }
        return sb.toString();
    }

}
