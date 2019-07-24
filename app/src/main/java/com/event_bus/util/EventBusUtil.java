package com.event_bus.util;

import com.example.customview.MyEventBusIndex;
import com.example.widget.BuildConfig;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mbc on 19-7-4
 * Description: EventBus工具类 -- 注解加速
 * 配合使用：
 * 1. 主项目build.gradle文件defaultConfig结点添加：
 * javaCompileOptions {
 * annotationProcessorOptions {
 * arguments = [eventBusIndex: '{applicationId}.MyEventBusIndex']
 * }
 * }
 * 2. 主项目build.gradle文件dependencies结点添加：
 * api 'org.greenrobot:eventbus:3.1.1'
 * annotationProcessor 'org.greenrobot:eventbus-annotation-processor:3.0.1'
 */
public class EventBusUtil {

    private static EventBusUtil instance;
    private EventBus localEventBus;

    private EventBusUtil() {
    }

    public synchronized static EventBusUtil getInstance() {
        if (instance == null) {
            synchronized (EventBusUtil.class) {
                if (instance == null) {
                    instance = new EventBusUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 打开加速 - 建议在Application onCreate中执行
     */
    public void openIndex() {
        EventBus.builder().throwSubscriberException(BuildConfig.DEBUG).addIndex(new MyEventBusIndex()).installDefaultEventBus();
        localEventBus = EventBus.getDefault();
    }

    /**
     * 获取默认实例
     *
     * @return
     */
    public EventBus getDefault() {
        if (localEventBus == null)
            localEventBus = EventBus.getDefault();
        return localEventBus;
    }

    /**
     * 注册
     *
     * @param subscriber
     */
    public void register(Object subscriber) {
        if (!getDefault().isRegistered(subscriber))
            getDefault().register(subscriber);
    }

    /**
     * 注销
     *
     * @param subscriber
     */
    public void unregister(Object subscriber) {
        getDefault().unregister(subscriber);
    }

    /**
     * 发布事件
     */
    public void post(Object publisher) {
        getDefault().post(publisher);
    }

    /**
     * 发布粘性事件
     */
    public void postSticky(Object publisher) {
        getDefault().postSticky(publisher);
    }

    /**
     * 移除粘性事件
     */
    public <T> void removeStickyEvent(Class<T> eventType) {
        T stickyEvent = getDefault().getStickyEvent(eventType);
        if (stickyEvent != null) {
            getDefault().removeStickyEvent(stickyEvent);
        }
    }

    /**
     * 取消事件传送 -- ThreadMode.PostThread下才能使用
     */
    public void cancleEventDelivery(Object event) {
        getDefault().cancelEventDelivery(event);
    }

    /**
     * 移除所有的粘性事件
     */
    public void removeAllStickyEvent() {
        getDefault().removeAllStickyEvents();
    }

}
