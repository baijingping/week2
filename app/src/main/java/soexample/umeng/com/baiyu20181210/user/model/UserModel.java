package soexample.umeng.com.baiyu20181210.user.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import soexample.umeng.com.baiyu20181210.api.Api;
import soexample.umeng.com.baiyu20181210.bean.UserBean;
import soexample.umeng.com.baiyu20181210.utils.HttpUtils;
import soexample.umeng.com.baiyu20181210.utils.ICallBack;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class UserModel {
    public void getData(String uid, final ICallBack callBack){
        Api api = HttpUtils.getInstance().creat(Api.class);
        api.user(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                         if (userBean!=null & "0".equals(userBean.getCode())){
                             callBack.successful(userBean);
                         }else {
                             callBack.failed(new Exception(userBean.getMsg()));
                         }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                         callBack.failed((Exception) throwable);
                    }
                });
    }
}
