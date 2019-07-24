package com.example.widget.mockito;

import android.content.Context;

import com.example.widget.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by mbc on 19-7-13
 * Description:
 */
@RunWith(MockitoJUnitRunner.class)/*使用注解mock对象，需要在使用前进行初始化*/
public class MockUnitTest {
    private static final String FAKE_STRING = "AndroidUnitTest";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {
        // 模拟Context.getString的返回值，之后mMockContext.getString(R.string.app_name)返回的值都是thenReturn(FAKE_STRING)中FAKE_STRING的值
        when(mMockContext.getString(R.string.app_name)).thenReturn(FAKE_STRING);
        System.out.println(mMockContext.getString(R.string.app_name));
        assertThat(mMockContext.getString(R.string.app_name), is(FAKE_STRING));

        when(mMockContext.getPackageName()).thenReturn("com.jdqm.androidunittest");
        System.out.println(mMockContext.getPackageName());
    }
}
