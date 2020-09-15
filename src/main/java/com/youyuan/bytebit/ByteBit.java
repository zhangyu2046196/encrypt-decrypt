package com.youyuan.bytebit;

/**
 * 类名称：ByteBit <br>
 * 类描述： byte和bit对应关系 <br>
 * <p>
 * 1byte=8bit
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/4 8:16<br>
 */
public class ByteBit {

    public static void main(String[] args) {
        //字符串
        String b = "a";
        //字符串转为byte数组
        byte[] bytes = b.getBytes();
        //循环字节数组，转为ascii十进制
        for (byte aByte : bytes) {
            int c = aByte;
            System.out.println("转换为ascii十进制：" + c);
            //byte转为bit
            String s = Integer.toBinaryString(c);
            System.out.println("字符串转为bit：" + s);
        }

    }

}
