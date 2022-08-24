package com.zzx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: 周志雄
 * @Description: Test
 * @date: 2022-08-24 10:27
 * @ClassName: MyTest
 */

@SpringBootTest
public class MyTest {

    @Test
    public void test01(){
        String name="yyyy.666.png";
        int suffix = name.lastIndexOf(".");
        //截取字符串
        System.out.println(name.substring(suffix));
    }
}
