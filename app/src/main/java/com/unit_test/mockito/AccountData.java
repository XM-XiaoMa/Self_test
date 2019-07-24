package com.unit_test.mockito;

/**
 * Created by mbc on 19-7-13
 * Description:
 */
public class AccountData {
    private boolean isLogin;
    private String userName;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        System.out.println(userName);
        this.userName = userName;
    }
}
