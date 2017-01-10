package com.fuxuemingzhu.qarobot.model.bean;

import com.alibaba.fastjson.JSON;

/**
 * 包名：com.fuxuemingzhu.qarobot.model.bean
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 19:34
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 19:34
 * 修改备注：
 *
 * @version 1.0
 */
public class Answer {

    private int code;
    private String text;

    public Answer() {
    }

    public Answer(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
