package soexample.umeng.com.baiyu20181210.joken.view;

import soexample.umeng.com.baiyu20181210.bean.ShopBean;

/**
 * Created by Shinelon on 2018/12/10.
 */

public interface JokenView {
    void successful(ShopBean data);

    void failed(Exception e);
}
