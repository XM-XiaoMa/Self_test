package com.event_bus.entity;

/**
 * Created by mbc on 19-7-4
 * Description: 定义传输的数据类型
 */
public class MessageEvent {
    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
