package com.atguigu.crowd;

import com.atguigu.crowd.util.CrowdUtil;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

/**
 * Created: 2024/3/2
 * Author: Li Yijia
 * Description:
 */
public class CrowdUtilTest {

    @Test
    public void testMd5() {
        System.out.println(CrowdUtil.md5("123123"));

    }

}
