package com.fuxuemingzhu.qarobot.model.bean;

import com.alibaba.fastjson.JSON;

/**
 * 包名：com.fuxuemingzhu.qarobot.model.bean
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 21:25
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 21:25
 * 修改备注：
 *
 * @version 1.0
 */
public class ChatBean {
    private String sourse;
    private String time;
    private String content;

    public ChatBean() {
    }

    public ChatBean(String content, String sourse, String time) {
        this.content = content;
        this.sourse = sourse;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
