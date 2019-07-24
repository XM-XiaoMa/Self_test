package com.example.widget.mockito;

import android.content.Context;

import com.example.widget.R;
import com.unit_test.mockito.AccountData;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mbc on 19-7-13
 * Description:
 * 1. 模拟方法返回值：when(...).thenReturn(...);
 * 2. 模拟参数测试： verify(...).setUserName();...
 * 3. 统计方法被调用次数：
 */
@RunWith(MockitoJUnitRunner.class)/*使用注解mock对象，需要在使用前进行初始化*/
public class AccountMockUnitTest {

    @Mock
    AccountData accountData;

    @Test
    public void testIsLogin() {
        when(accountData.isLogin()).thenReturn(true);
        assertTrue(accountData.isLogin());
    }

    @Test
    public void testGetUserName() {
        when(accountData.getUserName()).thenReturn("xiaoma");
        assertEquals(accountData.getUserName(), "xiaoma");
        System.out.println(accountData.getUserName());
    }

    @Test
    public void testSetUserName() {
        accountData.setUserName("xiaoma");
        verify(accountData).setUserName("xiaoma");
    }

    @Test
    public void testIsLoginTimes() {

    }
}
