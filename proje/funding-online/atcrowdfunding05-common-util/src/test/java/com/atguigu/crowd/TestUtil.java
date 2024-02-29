package com.atguigu.crowd;

import org.junit.Test;

import static com.atguigu.crowd.util.CrowdUtil.md5;

/**
 * Created: 2024/2/29
 * Author: Li Yijia
 * Description:
 */
public class TestUtil {

    @Test
    public void testMd5() {
        System.out.println(md5("123123"));
    }

}
