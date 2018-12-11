package soexample.umeng.com.baiyu20181210.user.view;

import soexample.umeng.com.baiyu20181210.bean.UserBean;

/**
 * Created by Shinelon on 2018/12/10.
 */

public interface UserView {
    void successful(UserBean data);

    void failed(Exception e);
}
