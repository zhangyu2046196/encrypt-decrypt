package com.youyuan.string;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * 类名称：StringDemo <br>
 * 类描述： 测试toString和new String区别 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/9/8 8:19<br>
 */
public class StringDemo {

    public static void main(String[] args) {

        String str = "TU0jV0xBTiNVYys5bEdiUjZlNU45aHJ0bTdDQStBPT0jNjQ2NDY1Njk4IzM5OTkwMDAwMzAwMA==";

        String rlt1 = new String(Base64.decode(str));

        String rlt2 = Base64.decode(str).toString();

        System.out.println(rlt1);

        System.out.println(rlt2);
    }

}
