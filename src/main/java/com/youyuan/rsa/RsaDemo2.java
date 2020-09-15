package com.youyuan.rsa;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.io.FileUtils;
import sun.security.rsa.RSAPrivateKeyImpl;
import sun.security.rsa.RSAPublicKeyImpl;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.charset.Charset;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 类名称：RsaDemo2 <br>
 * 类描述： 保存公钥和私钥 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/15 6:23<br>
 */
public class RsaDemo2 {

    public static void main(String[] args) throws Exception {
        //原文
        String input = "北京";
        //加密算法
        String algorithm = "RSA";
        //公钥路径信息
        String publicKeyPath = "publickey.txt";
        //私钥路径信息
        String privateKeyPath = "privateKey.txt";

        //保存秘钥对文件
//        genaratorKeyPair(algorithm, publicKeyPath, privateKeyPath);

        //读取公钥和私钥  Charset.defaultCharset() 代表读取秘钥的编码和生成秘钥的编码一致
        String publicKey = FileUtils.readFileToString(new File(publicKeyPath), Charset.defaultCharset());
        String privateKey = FileUtils.readFileToString(new File(privateKeyPath), Charset.defaultCharset());
        //加密
        String cipherText = encrypt(algorithm, publicKey, input);
        System.out.println("密文:" + cipherText);
        //解密
        String source = decrypt(algorithm, privateKey, cipherText);
        System.out.println("原文:" + source);
    }

    /**
     * 方法名: genaratorKeyPair <br>
     * 方法描述: 保存公钥和私钥到文件 <br>
     *
     * @param algorithm      加密算法
     * @param publicKeyPath  公钥保存路径
     * @param privateKeyPath 私钥保存路径
     * @date 创建时间: 2020/9/15 6:25 <br>
     * @author zhangyu
     */
    public static void genaratorKeyPair(String algorithm, String publicKeyPath, String privateKeyPath) throws
            Exception {
        //获取秘钥生成器对象
        KeyPairGenerator instance = KeyPairGenerator.getInstance(algorithm);
        //获取秘钥对
        KeyPair keyPair = instance.genKeyPair();
        //获取公钥
        PublicKey aPublic = keyPair.getPublic();
        //获取私钥
        PrivateKey aPrivate = keyPair.getPrivate();
        //获取公钥字节数组
        byte[] publicEncoded = aPublic.getEncoded();
        //获取私钥字节数组
        byte[] privateEncoded = aPrivate.getEncoded();
        //公钥和私钥用Base64转码
        String publicKey = Base64.encode(publicEncoded);
        String privateKey = Base64.encode(privateEncoded);
        //使用FileUtils工具类保存公钥私钥到文件
        FileUtils.writeStringToFile(new File(publicKeyPath), publicKey, Charset.forName("UTF-8"));
        FileUtils.writeStringToFile(new File(privateKeyPath), privateKey, Charset.forName("UTF-8"));


    }

    /**
     * 方法名: encrypt <br>
     * 方法描述: 加密方法 <br>
     *
     * @param algorithm 加密算法
     * @param publicKey 公钥
     * @param input     原文
     * @return {@link  String 返回加密后的密文}
     * @date 创建时间: 2020/9/15 6:47 <br>
     * @author zhangyu
     */
    public static String encrypt(String algorithm, String publicKey, String input) throws Exception {
        //获取加密对象
        Cipher cipher = Cipher.getInstance(algorithm);
        //根据公钥创建公钥对象
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        byte[] encodedKey = Base64.decode(publicKey);
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
        //初始化加密对象
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        //执行加密方法且Base64转码
        return Base64.encode(cipher.doFinal(input.getBytes()));
    }

    /**
     * 方法名: decrypt <br>
     * 方法描述: 解密方法 <br>
     *
     * @param algorithm  解密算法
     * @param privateKey 私钥
     * @param cipherText 密文
     * @return {@link String 返回解密后的明文}
     * @date 创建时间: 2020/9/15 6:55 <br>
     * @author zhangyu
     */
    public static String decrypt(String algorithm, String privateKey, String cipherText) throws Exception {
        //获取解密对象
        Cipher cipher = Cipher.getInstance(algorithm);

        //根据私钥创建私钥对象
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
        KeyFactory keyf = KeyFactory.getInstance(algorithm);
        PrivateKey priKey = keyf.generatePrivate(priPKCS8);
        //初始化解密对象
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        //执行解密方法且Base64转码
        return new String(cipher.doFinal(Base64.decode(cipherText)));
    }

}
