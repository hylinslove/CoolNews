package com.warren.meng.topnews.view;

import com.warren.meng.topnews.modle.bean.BeanMain;

/**
 * Created by meng on 2016/11/8.
 */

public interface IMain {

    void dataGot(BeanMain.ResultBean data);
    void dataGotFailure();

}
