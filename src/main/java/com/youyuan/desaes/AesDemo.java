package com.youyuan.desaes;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 类名称：AesDemo <br>
 * 类描述： 测试aes加密 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/8 6:50<br>
 */
public class AesDemo {

    public static void main(String[] args) throws Exception {
        //原文
        String input = "北京";
        //秘钥  秘钥必须是8个字节 否则报错
        String key = "1234567887659321";
        //定义加算法
        String transformation = "AES";
        //定义加密类型
        String algorithm = "AES";
        String encryptStr = encryptDes(input, key, transformation, algorithm);
        System.out.println("加密的密文是:" + encryptStr);
        String decryptDes = decryptDes(encryptStr, key, transformation, algorithm);
        System.out.println("解密后的明文是:" + decryptDes);


    }

    /**
     * 方法名: encryptDes <br>
     * 方法描述: des加密方式 <br>
     *
     * @param input          原文
     * @param key            秘钥
     * @param transformation 加密算法
     * @param algorithm      加密类型
     * @return {@link String 返回密文 }
     * @date 创建时间: 2020/9/8 7:08 <br>
     * @author zhangyu
     */
    private static String encryptDes(String input, String key, String transformation, String algorithm) throws
            Exception {
        //创建加密对象 参数代表使用哪种加密算法
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定秘钥规则
        // 第一个参数表示：密钥，key的字节数组
        // 第二个参数表示：算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        // 对加密进行初始化
        // 第一个参数：表示模式，有加密模式和解密模式
        // 第二个参数：表示秘钥规则
        cipher.init(Cipher.ENCRYPT_MODE, sks);
        // 进行加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        //可以把密文用Base64编码加密使密文能够正常显示
        String encode = Base64.encode(bytes);
        return encode;
    }

    /**
     * 方法名: decryptDes <br>
     * 方法描述: des解密方式 <br>
     *
     * @param encryptStr     密文
     * @param key            秘钥
     * @param transformation 加密算法
     * @param algorithm      加密类型
     * @return {@link String 返回密文 }
     * @date 创建时间: 2020/9/8 7:08 <br>
     * @author zhangyu
     */
    private static String decryptDes(String encryptStr, String key, String transformation, String algorithm) throws
            Exception {
        //创建加密对象 参数代表使用哪种加密算法
        Cipher cipher = Cipher.getInstance(transformation);
        // 指定秘钥规则
        // 第一个参数表示：密钥，key的字节数组
        // 第二个参数表示：算法
        SecretKeySpec sks = new SecretKeySpec(key.getBytes(), algorithm);
        // 对加密进行初始化
        // 第一个参数：表示模式，有加密模式和解密模式
        // 第二个参数：表示秘钥规则
        cipher.init(Cipher.DECRYPT_MODE, sks);
        // 进行解密
        byte[] bytes = cipher.doFinal(Base64.decode(encryptStr));
        return new String(bytes);
    }

}
