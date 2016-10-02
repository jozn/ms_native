package com.mardomsara.social.base.Http.listener;

import com.mardomsara.social.base.Http.Result;

public interface  CallBack<T> {
    public void callback(Result<T> result);
}
