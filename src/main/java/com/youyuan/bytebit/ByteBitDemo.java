package com.youyuan.bytebit;

/**
 * 类名称：ByteBitDemo <br>
 * 类描述： 测试字符串转bit <br>
 * <p>
 * UTF-8编码一个中文占3个字节
 * GBK编码一个中文占2个字节
 * 英文不论什么编码都占1个字节
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/4 10:27<br>
 */
public class ByteBitDemo {

    public static void main(String[] args) {
        String str = "北京";
        //转成字节数组
        byte[] bytes = str.getBytes();
        //StringBuilder用于收集bit
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        //遍历字节数组
        for (byte aByte : bytes) {
            System.out.println("字节数组元素：" + aByte);
            sb.append(Integer.toBinaryString(aByte)).append("\n");
        }
        System.out.println("字符串转为ASCII码十进制：" + sb.toString());
    }

}
