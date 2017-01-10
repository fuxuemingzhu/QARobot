package com.fuxuemingzhu.qarobot.model.callback;

import com.jude.http.RequestListener;

/**
 * 包名：com.fuxuemingzhu.qarobot.model.callback
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2017/1/9 19:43
 * <p>
 * 修改人：fuxuemingzhu
 * 修改时间：2017/1/9 19:43
 * 修改备注：
 *
 * @version 1.0
 */
public class LinkCallback implements RequestListener {

    private LinkCallback link;

    public LinkCallback add(LinkCallback other) {
        other.setLink(this);
        return other;
    }

    public void setLink(LinkCallback link) {
        this.link = link;
    }


    @Override
    public void onRequest() {
        if (link != null)
            link.onRequest();
    }

    @Override
    public void onSuccess(String response) {
        if (link != null)
            link.onSuccess(response);
    }

    @Override
    public void onError(String errorMsg) {
        if (link != null)
            link.onError(errorMsg);
    }
}
