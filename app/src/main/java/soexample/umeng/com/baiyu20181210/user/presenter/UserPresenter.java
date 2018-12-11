package soexample.umeng.com.baiyu20181210.user.presenter;

import soexample.umeng.com.baiyu20181210.bean.UserBean;
import soexample.umeng.com.baiyu20181210.user.model.UserModel;
import soexample.umeng.com.baiyu20181210.user.view.UserView;
import soexample.umeng.com.baiyu20181210.utils.ICallBack;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class UserPresenter {
    private UserView uv;
    private UserModel model;
    public void attach(UserView uv){
        this.uv=uv;
        model=new UserModel();
    }

    public void getData(String uid){
        model.getData(uid, new ICallBack() {
            @Override
            public void successful(Object o) {
                UserBean data= (UserBean) o;
                if (data!=null){
                    uv.successful(data);
                }
            }

            @Override
            public void failed(Exception e) {
                    uv.failed(e);
            }
        });
    }

    public void detach(){
        if (uv!=null){
            uv=null;
        }
    }
}
