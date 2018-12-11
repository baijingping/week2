package soexample.umeng.com.baiyu20181210.joken.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import soexample.umeng.com.baiyu20181210.api.Api;
import soexample.umeng.com.baiyu20181210.bean.ShopBean;
import soexample.umeng.com.baiyu20181210.utils.HttpUtils;
import soexample.umeng.com.baiyu20181210.utils.ICallBack;

/**
 * Created by Shinelon on 2018/12/10.
 */

public class JokenModel {
    public void getData(String source, String appVersion, int page, final ICallBack callBack){
        Api api = HttpUtils.getInstance().creat(Api.class);
        api.shop(source,appVersion,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean shopBean) throws Exception {
                         if (shopBean!=null & "0".equals(shopBean.getCode())){
                             callBack.successful(shopBean);
                         }else {
                             callBack.failed(new Exception(shopBean.getMsg()));
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
