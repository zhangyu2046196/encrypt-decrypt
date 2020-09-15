package com.youyuan.rsa;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/9/10 19:37
 */
public class RsaDemo {

    public static void main(String[] args) throws Exception {
        //原文
        String input = "北京";

        //加密算法
        String algorithm = "RSA";
        //创建生成密钥对对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //获取公钥
        PublicKey publicKey = keyPair.getPublic();
        //获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        //获取公钥字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        //获取私钥字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();
        //公钥通过Base64编码
        String publicEncode = Base64.encode(publicKeyEncoded);
        //私钥通过Base64编码
        String privateEncode = Base64.encode(privateKeyEncoded);
        System.out.println("公钥：" + publicEncode);
        System.out.println("私钥：" + privateEncode);


        //加密逻辑(私钥加密公钥解密)
        //创建加密对象，参数是加密算法
        Cipher cipher = Cipher.getInstance(algorithm);
        //初始化
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        //调用doFinal方法加密
        byte[] bytes = cipher.doFinal(input.getBytes());
        //输出加密后的内容
        System.out.println("加密后密文："+ Base64.encode(bytes));
    }

}
