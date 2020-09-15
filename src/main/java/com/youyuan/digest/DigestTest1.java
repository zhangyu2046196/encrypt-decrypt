package com.youyuan.digest;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 类名称：DigestTest1 <br>
 * 类描述： 散列加密之MD5加密 <br>
 * <p>
 * 散列加密作用是防止数据被篡改
 * <p>
 * MD5加密生成的摘要信息是128bit
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/9 7:14<br>
 */
public class DigestTest1 {

    public static void main(String[] args) throws Exception {
        //原文
        String input = "北京";
        //加密算法
        String algorithm = "MD5";
        String md5 = getDigest(input, algorithm);
        System.out.println("md5：" + md5);

        String sha1 = getDigest(input, "SHA-1");
        System.out.println("sha1：" + sha1);

        String sha256 = getDigest(input, "SHA-256");
        System.out.println("sha256：" + sha256);

        String sha512 = getDigest(input, "SHA-512");
        System.out.println("sha512：" + sha512);
    }

    /**
     * 方法名: getDigest <br>
     * 方法描述: 获取签名串 <br>
     *
     * @param input     原文
     * @param algorithm 加密算法 MD5/SHA1/SHA256/SHA512
     * @return {@link String 返回签名串 }
     * @date 创建时间: 2020/9/9 7:51 <br>
     * @author zhangyu
     */
    private static String getDigest(String input, String algorithm) throws Exception {
        //创建消息摘要对象
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        //对原文进行摘要处理
        byte[] bytes = digest.digest(input.getBytes());
        return toHex(bytes);
    }

    /**
     * 方法名: toHex <br>
     * 方法描述: 把签名串改成16进制输出 <br>
     *
     * @param bytes 字节数组
     * @return {@link String 返回16进制内容 }
     * @date 创建时间: 2020/9/9 7:50 <br>
     * @author zhangyu
     */
    private static String toHex(byte[] bytes) {
        //接收16进制内容
        StringBuilder sb = new StringBuilder();
        //把字节数组转成16进制，注意如果长度是1需要在高位补0
        for (byte aByte : bytes) {
            //把字节转成16进制
            String s = Integer.toHexString(aByte & 0xff);
            if (s.length() == 1) {
                s = "0" + s;
            }
            sb.append(s);
        }
        //输出生成的摘要
        return sb.toString();
    }

}
